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
			Player player = (Player) sender;
			player.sendMessage(replymap.toString());
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
			message = colourize(message);
		}
		sendto.sendMessage(ChatColor.YELLOW + "PMS " +name +message);
		String namesent = (Chat.getRankColour(sendto) +sendto.getName() + ChatColor.WHITE+": ");
		player.sendMessage(ChatColor.YELLOW + "PMS sent to " +namesent +message);
		return;
	}
	private String colourize(String message){
		char ColourSymbol = '\u00A7';
		message = message.replaceAll("&0", ColourSymbol + "0");
		message = message.replaceAll("&1", ColourSymbol + "1");
		message = message.replaceAll("&2", ColourSymbol + "2");
		message = message.replaceAll("&3", ColourSymbol + "3");
		message = message.replaceAll("&4", ColourSymbol + "4");
		message = message.replaceAll("&5", ColourSymbol + "5");
		message = message.replaceAll("&6", ColourSymbol + "6");
		message = message.replaceAll("&7", ColourSymbol + "7");
		message = message.replaceAll("&8", ColourSymbol + "8");
		message = message.replaceAll("&9", ColourSymbol + "9");
		message = message.replaceAll("&a", ColourSymbol + "a");
		message = message.replaceAll("&b", ColourSymbol + "b");
		message = message.replaceAll("&c", ColourSymbol + "c");
		message = message.replaceAll("&d", ColourSymbol + "d");
		message = message.replaceAll("&e", ColourSymbol + "e");
		message = message.replaceAll("&f", ColourSymbol + "f");
		message = message.replaceAll("&l", ColourSymbol + "l");
		message = message.replaceAll("&m", ColourSymbol + "m");
		message = message.replaceAll("&n", ColourSymbol + "n");
		message = message.replaceAll("&o", ColourSymbol + "o");
		message = message.replaceAll("&k", ColourSymbol + "k");
		return message;
	}
}
