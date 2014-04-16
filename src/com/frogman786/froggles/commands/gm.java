package com.frogman786.froggles.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gm implements CommandExecutor {
// TODO add if args[0] = 0,1,2,on,off,adventure.survival,creative then setgm() and if args.length == 2 do set with playerto
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		if(sender instanceof Player){
			Player player = (Player) sender;
				if( args.length == 0 && player.hasPermission("frog.gamemode.self")){
					togglegm(player);
					return true;
				}else{
					if( args.length == 1 && player.hasPermission("frog.gamemode.other")){
						Player playerto = Bukkit.getServer().getPlayer(args[0]);
						if(playerto != null){
							togglegm(playerto);
							player.sendMessage("Gamemode toggled for " + playerto.getDisplayName());
							return true;
						}else{
							player.sendMessage(ChatColor.RED + "Could not find player " + args[0]);
							return true;
						}
					}else{
						player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
						return true;
					}
				}
			}else{
				sender.sendMessage("no console use!");
			}
		return false;
	}
	public void togglegm(Player p){
		if (p.getGameMode() == org.bukkit.GameMode.CREATIVE) {
            p.setGameMode(org.bukkit.GameMode.SURVIVAL);
            p.sendMessage("Gamemode set to" + ChatColor.DARK_GREEN + " survival");
        } else {
            p.setGameMode(org.bukkit.GameMode.CREATIVE);
			p.sendMessage("Gamemode set to" + ChatColor.DARK_GREEN + " creative");
        }
	}
	public void setgm(Player p,int s){
		if(s == 0){
			if (p.getGameMode() == org.bukkit.GameMode.CREATIVE) {
				p.setGameMode(org.bukkit.GameMode.SURVIVAL);
				p.sendMessage("Gamemode set to" + ChatColor.DARK_GREEN + " survival");
			} else {
				p.sendMessage("Gamemode is already" + ChatColor.DARK_GREEN + " survival");
			}
		}
		if(s == 1){
			if (p.getGameMode() == org.bukkit.GameMode.SURVIVAL) {
				p.setGameMode(org.bukkit.GameMode.CREATIVE);
				p.sendMessage("Gamemode set to" + ChatColor.DARK_GREEN + " creative");
			} else {
				p.sendMessage("Gamemode is already" + ChatColor.DARK_GREEN + " creative");
			}
		}
		if(s == 2){
			if (p.getGameMode() == org.bukkit.GameMode.SURVIVAL||p.getGameMode() == org.bukkit.GameMode.CREATIVE) {
				p.setGameMode(org.bukkit.GameMode.ADVENTURE);
				p.sendMessage("Gamemode set to" + ChatColor.DARK_GREEN + " adventure");
			} else {
				p.sendMessage("Gamemode is already" + ChatColor.DARK_GREEN + " adventure");
			}
		}
	}
}
