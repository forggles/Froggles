package com.frogman786.froggles.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.frogman786.froggles.Froggles;

public class vbcommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		boolean allow = false;
		if(sender instanceof Player){
			Player player = (Player) sender;
			allow = player.hasPermission("frog.bullets.voxel");
		}else{
		    allow = true;
		}
		if(allow){
			if(args.length == 1){
				String name = args[0].toLowerCase();
				if(Froggles.voxelbullets.contains(name)){
					Froggles.voxelbullets.remove(Froggles.voxelbullets.indexOf(name));
					sender.sendMessage(name + " removed");
				}else{
				Froggles.voxelbullets.add(name);
				sender.sendMessage(name + " added");
				}
			}else if(args.length == 2){
				String name = args[0].toLowerCase();
				if(args[1].equalsIgnoreCase("on")){
					if(Froggles.voxelbullets.contains(name)){
						sender.sendMessage(name + " already added");
					}else{
						Froggles.voxelbullets.add(name);
						sender.sendMessage(name + " added");
					}
				}else if(args[1].equalsIgnoreCase("off")){
					if(Froggles.voxelbullets.contains(name)){
						Froggles.voxelbullets.remove(Froggles.voxelbullets.indexOf(name));
						sender.sendMessage(name + " removed");
					}else{
						sender.sendMessage(name + " not in list");
					}
				}else{
					sender.sendMessage("use /voxelbullets <player> [on/off]");
				}
			}else{
				sender.sendMessage("use /voxelbullets <player> [on/off]");
			}
			
		}else{
			sender.sendMessage("no perms");
		}
		return true;
	}

}
