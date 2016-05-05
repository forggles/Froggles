package com.frogman786.froggles.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.frogman786.froggles.Froggles;
import com.frogman786.froggles.utils.VelocityUtil;

public class launcher implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		double magic = 6.55478794302007;
		String throwerror = "/throw <player> set <x> <y> <z>\n/throw <player> adjust <x> <y> <z>\n/throw <player> divide <x> <y> <z>\n/throw <player> multiply <x> <y> <z>\n/throw <player> blocks <x> <z>\n/throw <player> bt <x> <y> <z> <height_adjust>\nWarning blocks max range 25\nWarning bt is experimental";
		boolean allow = false;
		if(sender instanceof Player){
			Player player = (Player) sender;
			allow = player.hasPermission("frog.throw");
		}else{
		    allow = true;
		}
		if(allow){
			if(args.length == 5 || args.length == 6 || args.length == 4 || args.length == 3){
				Player player = Bukkit.getServer().getPlayer(args[0]);
				if(args.length == 5){
					if(args[1].equalsIgnoreCase("set")){
						float x = Float.parseFloat(args[2]);
						float y = Float.parseFloat(args[3]);
						float z = Float.parseFloat(args[4]);
						player.setVelocity(new org.bukkit.util.Vector(x, y, z));
					}
					if(args[1].equalsIgnoreCase("adjust")){
						double x = (Double.parseDouble(args[2]) + player.getVelocity().getX());
						double y = (Double.parseDouble(args[3]) + player.getVelocity().getY());
						double z = (Double.parseDouble(args[4]) + player.getVelocity().getZ());
						player.setVelocity(new org.bukkit.util.Vector(x, y, z));
					}
					if(args[1].equalsIgnoreCase("divide")){
						double x = (Double.parseDouble(args[2]) / player.getVelocity().getX());
						double y = (Double.parseDouble(args[3]) / player.getVelocity().getY());
						double z = (Double.parseDouble(args[4]) / player.getVelocity().getZ());
					player.setVelocity(new org.bukkit.util.Vector(x, y, z));
					}	
					if(args[1].equalsIgnoreCase("multiply")){
						double x = (Double.parseDouble(args[2]) * player.getVelocity().getX());
						double y = (Double.parseDouble(args[3]) * player.getVelocity().getY());
						double z = (Double.parseDouble(args[4]) * player.getVelocity().getZ());
						player.setVelocity(new org.bukkit.util.Vector(x, y, z));
					}
				}else{
					if(args.length == 4 && args[1].equalsIgnoreCase("blocks")){
						double x = (Double.parseDouble(args[2]) / magic);
						double z = (Double.parseDouble(args[3]) / magic);
						player.setVelocity(new org.bukkit.util.Vector(x, 1, z));
					}else if(args.length == 6 && args[1].equalsIgnoreCase("bt")){
						double x = Double.parseDouble(args[2]);
						double y = Double.parseDouble(args[3]);
						double z = Double.parseDouble(args[4]);
						int h = Integer.parseInt(args[5]);
						Vector vfrom = new Vector(0, 0, 0);
						Vector vto = new Vector(x,y,z);
						Vector vnew = VelocityUtil.calculateVelocity(vfrom, vto, h);
						player.setVelocity(vnew);
					}else if(args.length == 3 && args[1].equalsIgnoreCase("setgravity")){
						double gravity = Double.parseDouble(args[2]);
						Froggles.gravity = gravity;
						sender.sendMessage("gravity set to" + gravity);
					}
					
				}
				return true;
			}else{
				sender.sendMessage(throwerror);
				return true;
			}
		}else{
			sender.sendMessage(ChatColor.RED+"no perms");
		}
		return true;
	}
	
}

