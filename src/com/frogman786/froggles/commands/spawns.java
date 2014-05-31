package com.frogman786.froggles.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.frogman786.froggles.Froggles;

public class spawns implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl,String[] args) {
		boolean allow = false;
		if(sender instanceof Player){
			Player player = (Player) sender;
			if(player.hasPermission("frog.gamespawn")){
				allow = true;
			}
		}else{
			allow = true;
		}
		if(allow){
			if(args.length==4){
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null){
					int x = Integer.parseInt(args[1]);
					int y = Integer.parseInt(args[2]);
					int z = Integer.parseInt(args[3]);
					Froggles.spawnmapx.put(target.getName(),x);
					Froggles.spawnmapy.put(target.getName(),y);
					Froggles.spawnmapz.put(target.getName(),z);
					return true;
				}else{
					return true;
				}
			}else{
				if(args.length==2&&args[1].equalsIgnoreCase("none")){
					Player target = Bukkit.getPlayer(args[0]);
					Froggles.spawnmapx.remove(target.getName());
					Froggles.spawnmapy.remove(target.getName());
					Froggles.spawnmapz.remove(target.getName());
				}
				return true;
			}
		}
		return true;
	}

}
