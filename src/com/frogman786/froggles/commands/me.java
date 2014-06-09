package com.frogman786.froggles.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.frogman786.froggles.utils.Chat;
import com.frogman786.froggles.utils.filter;

public class me implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		StringBuilder messagefinal = new StringBuilder();
		String message = "";
		String name = "";
		for(String word : args){
			messagefinal.append(word + " ");
		}
		if(sender instanceof Player){
			Player player = (Player) sender;
			name = ("* " + Chat.getRankColour(player) + player.getName() + " " + ChatColor.WHITE);
				if(player.hasPermission("frog.chat.me")){
					message = Chat.formatmessage(messagefinal.toString());
				}else{
					message = messagefinal.toString();
				}
		}else{
			message = Chat.formatmessage(messagefinal.toString());
			name = ("* " + ChatColor.LIGHT_PURPLE + "Server " + ChatColor.WHITE);
		}
		if(sender instanceof Player){
			if(!(filter.swears(message))){
				Player player = (Player) sender;
				if(!(player.hasPermission("frog.filter.bypass"))){
					player.sendMessage(filter.nomessage());
					filter.notify(player, message);
				}
			}else{
				Bukkit.getServer().broadcastMessage(name + message);
			}
		}else{
			Bukkit.getServer().broadcastMessage(name + message);
		}
		return true;
	}
}
