package com.frogman786.froggles.commands;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.frogman786.froggles.Froggles;
import com.frogman786.froggles.utils.Chat;

public class time implements CommandExecutor {
	Map<String, String> cfgmap = Froggles.configmap;
	public boolean onCommand(CommandSender sender, Command command, String lbl, String[] args) {
			if(sender instanceof Player){
				Player player = (Player) sender;
				int period = 0;
				if(player.hasPermission("frog.time." + lbl)){
					if(lbl.equalsIgnoreCase("dawn")){
						period = 23000;
					}else{
						if(lbl.equalsIgnoreCase("day")){
							period = 0;
						}else{
							if(lbl.equalsIgnoreCase("noon")){
								period = 7000;
							}else{
								if(lbl.equalsIgnoreCase("dusk")){
									period = 12500;
								}else{
									period = 15000;
							}
						}
					}
				}
					World world = player.getWorld();
					String name = (Chat.getRankColour(player) + player.getName());
					String message = cfgmap.get("message.time");
					message = message.replaceAll("&name", name);
					message = message.replaceAll("&world", world.getName());
					message = message.replaceAll("&period", lbl);
					message = Chat.formatmessage(message);
					Bukkit.broadcastMessage(message);
					world.setTime(period);
					return true;
				}else{
					player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
					return true;
				}
		
			}else{
				sender.sendMessage("no console use! (yet)");
				return true;
			}
	}
}