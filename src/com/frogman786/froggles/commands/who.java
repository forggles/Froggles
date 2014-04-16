package com.frogman786.froggles.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class who implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		if(sender instanceof Player){
			Player player = (Player) sender;
			if(args.length == 0 && player.hasPermission("frog.who.who")){
				StringBuilder online = new StringBuilder();
				Player[] players = Bukkit.getOnlinePlayers();
				for(Player listplayer : players){
					// If a player is hidden from the sender don't show them in the list
					if(sender instanceof Player && !((Player) sender).canSee(listplayer))
						continue;				              
						if(online.length() > 0){
							online.append(", ");
						}	 
						online.append(listplayer.getDisplayName());
					}
					sender.sendMessage(ChatColor.GREEN +"Online players " + ChatColor.RED + players.length + ChatColor.WHITE + " : " + online.toString());
					return true;
				}else{
					if(args.length == 1){
						if(args[0].equalsIgnoreCase("info") && player.hasPermission("frog.who.info")){
							StringBuilder infoonline = new StringBuilder();
							Player[] players = Bukkit.getOnlinePlayers();
							for(Player listplayer : players){
								// If a player is hidden from the sender don't show them in the list
								if(sender instanceof Player && !((Player) sender).canSee(listplayer))
									continue;				              
									if(infoonline.length() > 0){
										infoonline.append("\n");
									} 
									int x = (int) listplayer.getLocation().getX();
									int y = (int) listplayer.getLocation().getY();
									int z = (int) listplayer.getLocation().getZ();
									infoonline.append(listplayer.getDisplayName() + ChatColor.WHITE + ", world: " + listplayer.getWorld().getName() + ", Location: " + x+","+y+","+z);
									
								}
								sender.sendMessage(ChatColor.GREEN +"Online players " + ChatColor.RED + players.length + ChatColor.WHITE + " :\n" + infoonline.toString());
								return true;
						}else{
							if(args[0].equalsIgnoreCase("*") && player.hasPermission("frog.who.world")){
								StringBuilder online = new StringBuilder();
								Player[] players = Bukkit.getOnlinePlayers();
								for(Player listplayer : players){
									// If a player is hidden from the sender don't show them in the list
									if(sender instanceof Player && !((Player) sender).canSee(listplayer))
										continue;				              
										if(online.length() > 0){
											online.append(", ");
										}	 
											online.append(listplayer.getDisplayName() +ChatColor.WHITE+"["+listplayer.getWorld().getName()+"]");
										}
										sender.sendMessage(ChatColor.GREEN +"Online players " + ChatColor.RED + players.length + ChatColor.WHITE + " : " + online.toString());
										return true;
							}else{
								player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
								return true;
						}
					}
				}
			}
		}else{
			sender.sendMessage("no console use yet!");
			return true;
		}
		return false;
	}
}