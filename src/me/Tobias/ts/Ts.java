package me.Tobias.ts;

import java.util.logging.Logger;

import me.Tobias.ts.Updater.UpdateResult;
import me.Tobias.ts.commands.*;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Ts extends JavaPlugin
{
<<<<<<< HEAD
	public String prefix = "[TeamSpeakIP] ";
=======

>>>>>>> 74fa5629f807302315dfbfaee18b11184197a924
    public static Ts instance;
	Logger log = Bukkit.getLogger();
	
	public void onDisable() 
    {
          log.info(prefix +"Plugin disabeld ");       
    }
    
    public void onEnable()
    {
<<<<<<< HEAD
    	if(this.getConfig().getBoolean("options.updater")){
    	  Updater updater = new Updater(this, 70774, this.getFile(), Updater.UpdateType.NO_DOWNLOAD, false); // Start Updater but just do a version check
    	  if(updater.getResult() == UpdateResult.UPDATE_AVAILABLE){
    		  log.info(prefix+"New version available! "+ updater.getLatestName());
    	  }
    	 
    	  
    	  
    	}
=======
    	
>>>>>>> 74fa5629f807302315dfbfaee18b11184197a924
    	/* Metrics */
    	if(this.getConfig().getBoolean("options.Metrics")){
    	try {
            
            Metrics metrics = new Metrics(this);
            metrics.start();
        } catch(Exception ex) {
        	// Failed to submit the stats :-(
        }
    	}
        
<<<<<<< HEAD
    	 log.info(prefix+"Plugin enabeld ");
    	 
    	 instance = this;
    	 this.getCommand("ts").setExecutor(new ts());
    	 PluginManager pm = this.getServer().getPluginManager();
    	 pm.registerEvents(new join(), this);
=======
    	 log.info("[TeamSpeakIp] Plugin enabeld ");
    	 
    	 instance = this;
    	 this.getCommand("ts").setExecutor(new ts());
    	 
>>>>>>> 74fa5629f807302315dfbfaee18b11184197a924
    	 this.getConfig().options().header("Plugin by Tobias_the_best_!                 "+"                          Change at your own risk");
    	 this.getConfig().addDefault("messages.reload", "�3Reload Erfolgreich!");
    	 this.getConfig().addDefault("messages.ts3", "�2Die TS3 IP von <ServerName> lautet: �1TobiasTheBest.de");
    	 this.getConfig().addDefault("messages.konsole", "Dieser Befehl kann nur von einen Spieler ausgef�rt werden!");
    	 this.getConfig().set("options.effects", true);
    	 this.getConfig().set("options.sounds", true);
    	 this.getConfig().set("options.Metrics", true);
<<<<<<< HEAD
    	 this.getConfig().set("options.updater", true);
=======
>>>>>>> 74fa5629f807302315dfbfaee18b11184197a924
    	 this.getConfig().options().copyDefaults(true);
    	 this.saveConfig();
    }
   
}
