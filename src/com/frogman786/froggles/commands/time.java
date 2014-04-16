package com.frogman786.froggles.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class time implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String lbl, String[] args) {
		if(lbl.equalsIgnoreCase("dawn")||lbl.equalsIgnoreCase("day")||lbl.equalsIgnoreCase("noon")||lbl.equalsIgnoreCase("dusk")||lbl.equalsIgnoreCase("night")){
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
					Bukkit.broadcastMessage(player.getPlayerListName() + ChatColor.WHITE +" Set " + ChatColor.DARK_GREEN + world.getName() + ChatColor.WHITE + " to " + lbl + ".");
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
		return false;
	}
}