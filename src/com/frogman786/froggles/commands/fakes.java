package com.frogman786.froggles.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import com.frogman786.froggles.utils.Chat;

public class fakes implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String lbl,String[] args) {
		if(lbl.equalsIgnoreCase("fakejoin")){
			    Player player = Bukkit.getPlayer(args[0]);
			    Enum<?> colour = Chat.getRankColour(player);
			    String plural = " players";
			    if(Bukkit.getOnlinePlayers().length == 1){
			    	plural = " player";
			    }
			    Bukkit.broadcastMessage(colour + player.getName() + ChatColor.WHITE + " logged in, making " + ChatColor.RED + Bukkit.getOnlinePlayers().length + ChatColor.GREEN + plural);
			return true;
		}else{
			Player player = Bukkit.getPlayer(args[0]);
		    Enum<?> colour = Chat.getRankColour(player);
		    String plural = " players";
		    if(Bukkit.getOnlinePlayers().length-1 == 1){
		    	plural = " player";
		    }
		    Bukkit.broadcastMessage(colour + player.getName() + ChatColor.WHITE + " quit, " + ChatColor.RED + (Bukkit.getOnlinePlayers().length - 1) + ChatColor.GREEN + plural + ChatColor.WHITE + " left");
			return true;
		}
	}

}
