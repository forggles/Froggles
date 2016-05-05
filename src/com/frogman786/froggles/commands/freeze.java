package com.frogman786.froggles.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.frogman786.froggles.Froggles;

public class freeze implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String lbl, String[] args) {
		if(sender instanceof Player){
			sender.sendMessage("feck off peach");
			return true;
		}else{
			if(lbl.equalsIgnoreCase("freeze")){
				Froggles.freezemap.put(args[0], "frozen");
				return true;
			}else{
				Froggles.freezemap.remove(args[0]);
				return true;
			}
		}
	}
}

