package com.frogman786.froggles.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class spleef implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("spleeflayer")){
			if(args.length >= 6){
				Material material = Material.SAND;
				if(args.length == 7){
					material = Material.getMaterial(args[6]);
				}
				World world = Bukkit.getWorld(args[0]);
				int x1 = Integer.parseInt(args[1]);
				int x2 = Integer.parseInt(args[2]);
				int z1 = Integer.parseInt(args[3]);
				int z2 = Integer.parseInt(args[4]);
				int y = Integer.parseInt(args[5]);
				int totalset = 0;
				int totalnotset = 0;
				if(y>0){
					if(x2>x1){
						if(x2-x1<50){
							if(z2>z1){
								if(z2-z1<50){
									for (int x = x1; x < x2; x++){
										for (int z = z1; z < z2; z++){
											Block b = world.getBlockAt(x, y, z);
											if(b.getType().equals(Material.AIR)){ 
												b.setType(material);
												totalset = totalset+1;
											}else{
												totalnotset = totalnotset+1;;
											}
										}
									}
									int total = totalset+totalnotset;
									sender.sendMessage("total blocks set: " + totalset +"/"+total);
									return true;
								}else{sender.sendMessage(ChatColor.RED + "Max size of 50*50");return true;}
							}else{
								sender.sendMessage(ChatColor.RED + "Usage: /spleeflayer <world> <X1> <X2> <Z1> <Z2> <Y>\nZ2 must be greater than or equal to Z1");return true;
							}
						}else{sender.sendMessage(ChatColor.RED + "Max size of 50*50");return true;}
					}else{
						sender.sendMessage(ChatColor.RED + "Usage: /spleeflayer <world> <X1> <X2> <Z1> <Z2> <Y>\nX2 must be greater than or equal to X1!");return true;
					}
				}else{
					sender.sendMessage(ChatColor.RED + "Usage: /spleeflayer <world> <X1> <X2> <Z1> <Z2> <Y>\nY must be positive!");return true;
				}
			}else{
				sender.sendMessage(ChatColor.RED + "Usage: /spleeflayer <world> <x1> <x2> <z1> <z2> <y>");
				return true;
			}
		}
		if(label.equalsIgnoreCase("cuboid")){
			if(args.length >= 7){
				Material material = Material.AIR;
				if(args.length == 8){
					material = Material.getMaterial(args[7]);
				}
				World world = Bukkit.getWorld(args[0]);
				int x1 = Integer.parseInt(args[1]);
				int y1 = Integer.parseInt(args[2]);
				int z1 = Integer.parseInt(args[3]);
				int x2 = Integer.parseInt(args[4]);
				int y2 = Integer.parseInt(args[5]);
				int z2 = Integer.parseInt(args[6]);
				int totalset = 0;
				int totalnotset = 0;
				sender.sendMessage(y1+","+y2+","+x1+","+x2+","+z1+","+z2);
				if(y2>y1&y2-y1<=50){
					sender.sendMessage("1");
					if(x2>x1&x2-x1<=50){
						sender.sendMessage("2");
						if(z2>z1&z2-z1<=50){
							sender.sendMessage("3");
							for (int x = x1; x < x2; x++){
								for (int z = z1; z < z2; z++){
									for (int y = y1; y < y2; y++){
										Block b = world.getBlockAt(x, y, z);
										if(!b.getType().equals(material)){
											b.setType(material);
											totalset = totalset+1;
											sender.sendMessage("setting: " +x+","+y+","+z);
										}else{
											totalnotset = totalnotset+1;;
										}
									}
								}
							}
							int total = totalset+totalnotset;
							sender.sendMessage("total blocks set: " + totalset +"/"+total);return true;
						}
					}
				}
			}else{
				sender.sendMessage(ChatColor.RED+"USAGE: /cuboid <world> <x1> <y1> <z1> <x2> <y2> <z2> [material]");return true;
			}
		}
		return false;
	}
}
