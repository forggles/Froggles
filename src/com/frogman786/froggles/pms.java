package com.frogman786.froggles;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.frogman786.froggles.Froggles;
import com.frogman786.froggles.utils.Chat;

public class pms implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String lbl, String[] args) {
		Map<String, String> replymap = Froggles.replymap;
		if(lbl.equalsIgnoreCase("pms")){
			if(sender instanceof Player){
				Player player = (Player) sender;
				Player sendto = Bukkit.getServer().getPlayer(args[0]);
				if(sendto == null){
					player.sendMessage(ChatColor.RED + "Player not found!");
				}else{
					args[0] = "";
					send(player,sendto,args);
					replymap.put(sendto.getName(), player.getName());
					return true;
				}
			}else{
				sender.sendMessage("no console use yet! use /tell instead");
				return true;
			}
		}
		if(lbl.equalsIgnoreCase("r")){
			if(sender instanceof Player){
				Player player = (Player) sender;
				if(replymap.containsKey(player.getName())){
					Player sendto = Bukkit.getServer().getPlayer(replymap.get(player.getName()));
					send(player,sendto,args);
					replymap.put(sendto.getName(), player.getName());
					return true;
				}else{
					player.sendMessage(ChatColor.RED + "Player not found!");
					return true;
				}
			}else{
				sender.sendMessage("no console use yet! use /tell instead");
				return true;
			}
		}
		if(lbl.equalsIgnoreCase("pmsdebug")){
			sender.sendMessage(replymap.toString());
			return true;
		}
		return false;
	}
	private void send(Player player,Player sendto, String[] args){
		StringBuilder messagefinal = new StringBuilder();
		String[] words = args;;
		for(String word: words){
			messagefinal.append(word + " ");
		}
		String name = (Chat.getRankColour(player) +player.getName() + ChatColor.WHITE+":");
		String message = messagefinal.toString();
		if(player.hasPermission("frog.chat.pms")){
			message = Chat.formatmessage(message);
		}
		sendto.sendMessage(ChatColor.YELLOW + "PMS " +name +message);
		String namesent = (Chat.getRankColour(sendto) +sendto.getName() + ChatColor.WHITE+": ");
		player.sendMessage(ChatColor.YELLOW + "PMS sent to " +namesent +message);
		return;
	}
}
