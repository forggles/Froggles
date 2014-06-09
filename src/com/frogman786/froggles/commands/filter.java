package com.frogman786.froggles.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.frogman786.froggles.Froggles;

public class filter implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl,String[] args) {
		if(args.length==2){
			if(args[0].equalsIgnoreCase("add")){
				boolean allow = true;
				if(sender instanceof Player){
					Player player = (Player) sender;
					if(player.hasPermission("frog.filter.add")){
						allow = true;
					}else{
						allow = false;
					}
				}
				if(allow){
					Froggles.swears.add(args[1]);
					sender.sendMessage(args[1] +" has been added to the filter.");
					return true;
				}
				return false;
			}else{
				boolean allow = true;
				if(sender instanceof Player){
					Player player = (Player) sender;
					if(player.hasPermission("frog.filter.remove")){
						allow = true;
					}else{
						allow = false;
					}
				}
				if(allow){
					Froggles.swears.remove(args[1]);
					sender.sendMessage(args[1] +" has been removed to the filter.");
					return true;
				}
				return false;
			}
		}else{
			if(args[0].equalsIgnoreCase("list")){
				boolean allow = true;
				if(sender instanceof Player){
					Player player = (Player) sender;
					if(player.hasPermission("frog.filter.list")){
						allow = true;
					}else{
						allow = false;
					}
				}
				if(allow){
					StringBuilder filtered = new StringBuilder();
					for(String word:Froggles.swears){
						filtered.append(word+", ");
					}
					sender.sendMessage(ChatColor.RED+"Chat Filter List:\n"+filtered.toString());
					return true;
				}
				return false;
			}else{
				sender.sendMessage("Usage: /filter [add/remove/list] [word]");
				return false;
			}
		}
	}

}
