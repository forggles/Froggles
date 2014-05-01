package com.frogman786.froggles.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.frogman786.froggles.Froggles;

public class tracking implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		if(label.equalsIgnoreCase("track")){
			if(args[0]!=null){
				if(sender instanceof Player){
					if(Froggles.trackingmap.containsKey(args[0])){
						sender.sendMessage(args[0]+" is already being tracked");
						return true;
					}else{
						Froggles.trackingmap.put(args[0], sender.getName());
						return true;
					}
				}
			}else{
				sender.sendMessage("requires a player to track");
				return true;
			}
		}
		if(label.equalsIgnoreCase("untrack")){
			if(!(sender instanceof Player)){
					Froggles.trackingmap.clear();
					return true;
				}else{
					sender.sendMessage("console or command blocks only");
					return true;
				}
			}
		return false;
	}

}
