package com.frogman786.froggles.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.frogman786.froggles.Froggles;

public class frogcommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		if(args.length>0){
			if(args[0].equalsIgnoreCase("test")){
				return Froggles.frogcommand;
			}else{
				if(args[0].equalsIgnoreCase("on")||args[0].equalsIgnoreCase("true")){
					Froggles.frogcommand = true;
					return true;
				}else{
					Froggles.frogcommand = false;
					return false;
				}
			}
		}else{
			sender.sendMessage("Usage: /frogcommand [test/set [on/off/true/false]]");
					return false;
		}
	}

}
