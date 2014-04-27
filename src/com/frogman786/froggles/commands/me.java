package com.frogman786.froggles.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.frogman786.froggles.utils.Chat;

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
				message = colourize(messagefinal.toString());
				}else{
					message = messagefinal.toString();
				}
			
		}else{
			message = colourize(messagefinal.toString());
			name = ("* " + ChatColor.LIGHT_PURPLE + "Server " + ChatColor.WHITE);
			}
		Bukkit.getServer().broadcastMessage(name + message);
		return true;
	}
	private String colourize(String message){
		char ColourSymbol = '\u00A7';
		message = message.replaceAll("&0", ColourSymbol + "0");
		message = message.replaceAll("&1", ColourSymbol + "1");
		message = message.replaceAll("&2", ColourSymbol + "2");
		message = message.replaceAll("&3", ColourSymbol + "3");
		message = message.replaceAll("&4", ColourSymbol + "4");
		message = message.replaceAll("&5", ColourSymbol + "5");
		message = message.replaceAll("&6", ColourSymbol + "6");
		message = message.replaceAll("&7", ColourSymbol + "7");
		message = message.replaceAll("&8", ColourSymbol + "8");
		message = message.replaceAll("&9", ColourSymbol + "9");
		message = message.replaceAll("&a", ColourSymbol + "a");
		message = message.replaceAll("&b", ColourSymbol + "b");
		message = message.replaceAll("&c", ColourSymbol + "c");
		message = message.replaceAll("&d", ColourSymbol + "d");
		message = message.replaceAll("&e", ColourSymbol + "e");
		message = message.replaceAll("&f", ColourSymbol + "f");
		message = message.replaceAll("&l", ColourSymbol + "l");
		message = message.replaceAll("&m", ColourSymbol + "m");
		message = message.replaceAll("&n", ColourSymbol + "n");
		message = message.replaceAll("&o", ColourSymbol + "o");
		message = message.replaceAll("&k", ColourSymbol + "k");
		return message;
	}
}
