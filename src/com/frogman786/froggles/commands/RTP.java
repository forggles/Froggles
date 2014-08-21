package com.frogman786.froggles.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.frogman786.froggles.utils.rTP;

public class RTP implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if(args.length==5||args.length==6){
			//initilizing varibles
			int x1 = 0;
			int x2 = 0;
			int y1 = 0;
			int y2 = 0;
			int safey = 200;
			//player check
			Player target = Bukkit.getPlayer(args[0]);
			if(target==null){
				sender.sendMessage(args[0]+"is not a player");
				return true;
			}
			
			//int check/assign
			try {
				x1 = Integer.parseInt(args[1]);
				x2 = Integer.parseInt(args[2]);
				y1 = Integer.parseInt(args[3]);
				y2 = Integer.parseInt(args[4]);
				if(args.length==6){
				safey = Integer.parseInt(args[5]);
				}
			} catch (Exception NumberFormatException) {
				sender.sendMessage("x1, x2, z1, z2, and y must be exact numbers");
				return true;
			}
			
			//check for ignore block
			//all varibles should go to tp util now
			rTP.rtp(target,x1,x2,y1,y2,safey);
			return true;
		}else{
			//send usage message
			sender.sendMessage(ChatColor.RED+"USAGE: /randomtp [player x1 x2 z1 z2] (y)");
			return true;
		}
	}

}
