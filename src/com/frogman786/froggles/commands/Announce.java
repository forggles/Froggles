package com.frogman786.froggles.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.frogman786.froggles.utils.Chat;

public class Announce implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		if(label.equalsIgnoreCase("announce")){
			if(args.length >= 1){
				String message = "";
				StringBuilder messagebuilder = new StringBuilder();
				for(String word: args){
					messagebuilder.append(word + " ");
				}
				message = messagebuilder.toString();
				if(sender instanceof Player){
					Player player = (Player) sender;
					if(player.hasPermission("frog.announce")){
						message = Chat.formatmessage(message);
						Bukkit.getServer().broadcastMessage(message);
						return true;
					}else{
						sender.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
					}
				}else{
					message = Chat.formatmessage(message);
					Bukkit.getServer().broadcastMessage(message);
					return true;
				}
			}
		}
		if(label.equalsIgnoreCase("announcepromo")){
			if(!(sender instanceof Player)){
				if(args.length == 2){
					String name = Chat.getRankColour(Bukkit.getServer().getPlayerExact(args[0]))+args[0];
					String message = ("&fPlayer "+name+" &fis now a "+args[1]);
					message = Chat.formatmessage(message);
					Bukkit.getServer().broadcastMessage(message);
				}
			}
		}
		return false;
	}
}
