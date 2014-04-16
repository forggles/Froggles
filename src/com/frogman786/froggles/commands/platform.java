package com.frogman786.froggles.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class platform implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		if(sender instanceof Player){
			Player player = (Player) sender;
		//NEED TO ADD REGION AND AIR CHECKING TO THIS
			if(player.hasPermission("frog.platform.single")){
			    Location loc = player.getPlayer().getLocation();
			    loc.setY(loc.getY() - 1);
			    Block b = loc.getBlock();
			    b.setType(Material.GLASS);
				player.sendMessage(ChatColor.DARK_GREEN + "Platform created.");
				return true;
			}else{
				player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
				return true;
			}
		}else{
			sender.sendMessage("until I add /platform <playername> this is a player command only");
			return true;
		}
	}

}
