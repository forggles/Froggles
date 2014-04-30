package com.frogman786.froggles.commands;

import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.frogman786.froggles.Froggles;

public class cfg implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		Map<String, String> cfgmap = Froggles.configmap;
		if(label.equalsIgnoreCase("cfgdebug")){
			sender.sendMessage(cfgmap.toString());
			return true;
		}
		return false;
	}

}
