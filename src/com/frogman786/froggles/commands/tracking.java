package com.frogman786.froggles.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.frogman786.froggles.Froggles;
import com.frogman786.froggles.utils.Tracking;

public class tracking implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		if(label.equalsIgnoreCase("track")){
			if(sender instanceof Player){
				if(Froggles.trackingmap.containsKey(sender.getName())){
					sender.sendMessage("you are already tracking");
					return true;
				}else{
					Froggles.trackingmap.put(sender.getName(),true);
					return true;
				}
			}else{
				sender.sendMessage("requires a player to execute");
				return true;
			}
		}
		if(label.equalsIgnoreCase("untrack")){
			if(!(sender instanceof Player)){
					Froggles.trackingmap.clear();
					sender.sendMessage("Tracking off");
					return true;
				}else{
					sender.sendMessage("console or command blocks only");
					return true;
				}
			}
		if(label.equalsIgnoreCase("trackdebug")){
			Player player = (Player) sender;
			player.sendMessage(String.valueOf(Tracking.getNearestDistance(player)));
		}
		return false;
	}

}
