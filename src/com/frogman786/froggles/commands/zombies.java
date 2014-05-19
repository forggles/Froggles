package com.frogman786.froggles.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.frogman786.froggles.Froggles;

public class zombies implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(sender instanceof Player){
			Player player = (Player) sender; 
			if(player.hasPermission("frog.zombies.protect")){
				if(args.length>0){
					if(args[0].equalsIgnoreCase("on")){
						Froggles.zom_vill_safe = true;
						sender.sendMessage("villagers protection on");
					}else{
						Froggles.zom_vill_safe = false;
						sender.sendMessage("villagers protection off");
					}
				}else{
					sender.sendMessage("Usage: /zombiesafety [on/off]");
					return true;
				}
			}else{
				player.sendMessage(ChatColor.RED+")you do not have permission to use this command!!!!!!!!!!!!!!!!!");
				return true;
			}
		}else{
			if(args.length>0){
				if(args[0]=="on"){
					Froggles.zom_vill_safe = true;
					sender.sendMessage("villagers protection on");
				}else{
					Froggles.zom_vill_safe = false;
					sender.sendMessage("villagers protection off");
				}
			}else{
				sender.sendMessage("Usage: /zombiesafety [on/off]");
				return true;
			}
		}
		return false;
	}

}
