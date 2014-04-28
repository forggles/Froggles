package com.frogman786.froggles;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import com.frogman786.froggles.utils.Chat;

public class Events implements Listener {
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event){
		Player player = event.getPlayer();
		String message = event.getMessage();
		if(player.hasPermission("frog.chat.open")){
			message = colourize(message);
		}
		event.setMessage(message);
		}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent evt) {
	    Player player = evt.getPlayer();
	    Enum<?> colour = Chat.getRankColour(player);
	    String plural = " players";
	    if(Bukkit.getOnlinePlayers().length == 1){
	    	plural = " player";
	    }
	    evt.setJoinMessage(colour + player.getName() + ChatColor.WHITE + " logged in, making " + ChatColor.RED + Bukkit.getOnlinePlayers().length + ChatColor.GREEN + plural);
	}
	
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent evt) {
	    Player player = evt.getPlayer();
	    Enum<?> colour = Chat.getRankColour(player);
	    String plural = " players";
	    if(Bukkit.getOnlinePlayers().length-1 == 1){
	    	plural = " player";
	    }
	    evt.setQuitMessage(colour + player.getName() + ChatColor.WHITE + " quit, " + ChatColor.RED + (Bukkit.getOnlinePlayers().length - 1) + ChatColor.GREEN + plural + ChatColor.WHITE + " left");
	}
	
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent evt){
		String message = evt.getDeathMessage();
		if(message.startsWith("frogman786 was slain")){
			String messagemodifyed = (message + ", but actually wasn't, because nobody can kill the great frog.");
			evt.setDeathMessage(messagemodifyed);
		}
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
