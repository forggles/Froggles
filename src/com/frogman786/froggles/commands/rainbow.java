package com.frogman786.froggles.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.frogman786.froggles.Froggles;

public class rainbow implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String lbl,String[] args) {
		if(sender instanceof Player){
			Player player = (Player) sender;
			if(player.hasPermission("frog.chat.rainbow")){
				if(Froggles.rainbowmap.containsKey(player.getName())){
					if(Froggles.rainbowmap.get(player.getName())){
						Froggles.rainbowmap.put(player.getName(), false);
						player.sendMessage("rainbow text off!");
					}else{
						Froggles.rainbowmap.put(player.getName(), true);
						player.sendMessage("rainbow text on!");
					}
				}else{
					Froggles.rainbowmap.put(player.getName(), true);
					player.sendMessage("rainbow text on!");
				}
			}
		}else{
			sender.sendMessage(ChatColor.RED + "Player only command!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			return true;
		}
		return false;
	}

}
