package me.t0biii.ts;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.spigotmc.Metrics;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;

import me.t0biii.ts.Methods.ConfigManager;
import me.t0biii.ts.Methods.Updater;
import me.t0biii.ts.Methods.Updater.UpdateType;
import me.t0biii.ts.commands.TsTapCompleter;
import me.t0biii.ts.commands.ts;
import me.t0biii.ts.listener.PlayerJoin;

public class Main extends JavaPlugin{

	public String prefix = "[TeamSpeakIP] ";
	public String Prefix = "�8[�6TeamSpeakIP�8] �f";
	public String updateURL = "http://dev.bukkit.org/bukkit-plugins/teamspeak-ip/files/";
	private int uid = 70774;
	public Updater updater;
	
	
	public static Main instance;
	public ConfigManager cm = new ConfigManager(this);
	Logger log = Bukkit.getLogger();

	public boolean error = false;
	     	
	public final TS3Config config = new TS3Config();
	public final TS3Query query = new TS3Query(config);
	public final TS3Api api = query.getApi();
	
	@Override
	public void onDisable() {
		log.info(prefix +"Plugin disabeld.");
	}

	@Override
	public void onEnable() {
		PluginManager pm = Bukkit.getPluginManager();
		instance = this;
		
		/**
		 * Config laden und speichern
		 */
		cm.loadConfig();
      	saveConfig();
    	
      	/**
    	 * TS Command and TapCompleter
    	 */
      	this.getCommand("ts").setExecutor(new ts());
     	this.getCommand("ts").setTabCompleter(new TsTapCompleter(this));
     	
     	/**
     	 * Events registrieren
     	 */
     	pm.registerEvents(new PlayerJoin(this),this);
     	
     	/**
     	 * TS3 Verbindung
     	 */
     	
		config.setHost(this.getConfig().getString("ts3.ip"));
		config.setQueryPort(this.getConfig().getInt("ts3.queryport"));
		config.setDebugLevel(Level.OFF);
		config.setLoginCredentials(this.getConfig().getString("ts3.querylogin.name"), this.getConfig().getString("ts3.querylogin.pw"));
		try{
		query.connect();
		log.info(prefix+"Connectet to Teamspeak!");
		}catch(Exception e){
			
			log.info(prefix+"Can�t connect to Teamspeak!");
			error = true;
		}
		
		if(!error){	
			try{
			api.selectVirtualServerByPort(getConfig().getInt("ts3.port"));
			api.setNickname("TeamspeakIP");
			error = false;
			}catch(Exception e){
				log.info(prefix+"Can�t connect to Teamspeak!");
			}						
		}
     	
     	
     	/**
     	 * Metrics sarten
     	 */
        try {
            Metrics metrics = new Metrics();
            metrics.start();
        } catch (IOException e) {
            // Failed to submit the stats :-(
        }
        
        /**
         * Updater hinwei� starten
         */
        updater = new Updater(this, uid, getFile(), UpdateType.NO_DOWNLOAD, true);       
	}
}
