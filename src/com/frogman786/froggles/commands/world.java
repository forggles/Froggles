package com.frogman786.froggles.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

public class world implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		if(sender instanceof Player){
			Player player = (Player) sender;
			if(player.hasPermission("frog.world.self") && args.length == 0){
				player.sendMessage(ChatColor.DARK_GREEN+"You are in"+ChatColor.WHITE+": "+ChatColor.YELLOW+player.getWorld().getName());
			}else{
				if(player.hasPermission("frog.world.other") && args.length == 1){
					Player other = Bukkit.getServer().getPlayer(args[0]);
					if(other == null){
						player.sendMessage(ChatColor.RED + "ERROR: player not found");
						return true;
					}else{
						player.sendMessage(other.getDisplayName() + ChatColor.DARK_GREEN + " is in"+ChatColor.WHITE+": "+ChatColor.YELLOW+other.getWorld().getName());
						return true;
					}
				}else{
					player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
					return true;
				}
			}
		}else{
			sender.sendMessage("no console use! (yet)");
			return true;
		}
		return false;
	}

}
