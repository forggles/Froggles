package com.frogman786.froggles.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class runcheck implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command arg1, String arg2,String[] args) {
		if(args.length == 2){
			int x = Integer.parseInt(args[0]);
			int y = Integer.parseInt(args[1]);
			int distance = (int) Math.sqrt((x*x)+(y*y));
			double time = (distance/5.612/60);
			sender.sendMessage("time to travel is approx: " + time + " minutes.");
			return true;
		}else{
			sender.sendMessage(ChatColor.RED +"USAGE: /runcheck <length1> <length2>");
			return true;
		}
	}

}
