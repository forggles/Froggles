package com.frogman786.froggles.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class chest implements CommandExecutor  {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl,String[] args) {
		// for checking player or console etc.
		boolean allow = true;
		if(sender instanceof Player){
			Player player = (Player) sender;
			if(player.hasPermission("frog.chests")){
			allow = true;
			}else{
				allow = false;
			}
		}
		if(allow){
			//main method
			if(args.length==5){
				int x = 0;
				int y;
				int z;
				World world = Bukkit.getWorld(args[0]);
				if(world != null){
					try{
						x = Integer.parseInt(args[1]);
						y = Integer.parseInt(args[2]);
						z = Integer.parseInt(args[3]);
					}catch (Exception NumberFormatException){
							sender.sendMessage(ChatColor.RED+"ERROR: x, y or z are not number");
							return false;
					}
					Block block = world.getBlockAt(x, y, z);
					block.setType(Material.CHEST);
					Inventory chest = (Inventory) block;
					chest.clear();
					//so far
					chest.addItem(items)
					
					
					
				}else{
					sender.sendMessage(ChatColor.RED+"ERROR: world is invalid");
				}
			}else{
				sender.sendMessage(ChatColor.RED+"Usage: /randomchest [world] [x] [y] [z] [tier]");
			}	
		}
		return false;
	}

}
