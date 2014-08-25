package com.frogman786.froggles.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class stp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		boolean allow = false;
		if(sender instanceof Player){
			Player player = (Player) sender;
			if(player.hasPermission("frog.tp.switch")){
				allow = true;
			}
		}else{
			allow = true;
		}
		if(allow){
			if(args.length==2){
				Player p1 = Bukkit.getPlayer(args[0]);
				Player p2 = Bukkit.getPlayer(args[1]);
				Location l1 = p1.getLocation();
				Location l2 = p2.getLocation();
				p1.teleport(l2);
				p2.teleport(l1);
			}else{
				sender.sendMessage(ChatColor.RED+"USAGE: /switchtp [player1] [player2]");
			}
		}else{
			sender.sendMessage(ChatColor.RED+"ERROR: no permission");
		}
		return false;
	}

}
