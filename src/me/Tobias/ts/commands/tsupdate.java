package me.Tobias.ts.commands;

import me.Tobias.ts.Ts;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tsupdate implements CommandExecutor{
	int t = 11;
	
	public static Ts pl = Ts.instance;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		if(sender instanceof Player)
		{
			final Player p = (Player) sender;
			if(p.hasPermission("ts.update")){
			
			ts.pl.froce();
		    p.sendMessage(ChatColor.RED + "Update in progress");
		    p.sendMessage( ChatColor.RED +"Wait "+ ChatColor.BLUE +"10"+ ChatColor.RED + " sek.");
		   
		    Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable(){

				@Override
				public void run() {
					Bukkit.dispatchCommand(p, "reload");
					
				}
		    	
		    }, 9*20L);
		   
		       
				}else{
				p.sendMessage(pl.getConfig().getString("messages.no-permission"));
			}
			
		}else{
			sender.sendMessage(pl.getConfig().getString("messages.konsole"));
		}
		
		
		return true;
}
}	


