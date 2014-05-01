package com.frogman786.froggles.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ban implements CommandExecutor {

	private void kick(Player target,Player kicker, String message){
		target.kickPlayer(message);
		Bukkit.getServer().broadcastMessage(ChatColor.RED+"Player "+ChatColor.WHITE+target.getDisplayName()+ChatColor.RED+" was kicked reason:"+ChatColor.GRAY+message);
	}
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("kick")){
			if(sender instanceof Player){
				Player player = (Player) sender;
				if(player.hasPermission("frog.ban.kick")){
					StringBuilder messagefinal = new StringBuilder();
					if(args.length>1){
						String[] messagearray = args;
						messagearray[0] = "";
						for(String word : messagearray){				              
							messagefinal.append(word + " ");
						}
						kick(Bukkit.getServer().getPlayer(args[0]),player,messagefinal.toString());
					}else{
						player.sendMessage(ChatColor.RED + "Usage: /kick <player> <reason>");
					}
				}
			}else{sender.sendMessage("no console use just yet");}
		}
		return false;
	}
	
}
