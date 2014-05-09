package com.frogman786.froggles;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import com.frogman786.froggles.utils.Chat;

public class Events implements Listener {
	@EventHandler (priority = EventPriority.LOWEST)
	public void onPlayerChat(AsyncPlayerChatEvent event){
		Player player = event.getPlayer();
		String message = event.getMessage();
		if(Froggles.rainbowmap.containsKey(player.getName())&Froggles.rainbowmap.get(player.getName())){
			message = Chat.rainbowText(message);
		}
		if(player.hasPermission("frog.chat.open")){
			message = Chat.formatmessage(message);
		}
		event.setMessage(message);
		}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent evt){
		Player player = evt.getPlayer();
		if(Froggles.trackingmap.containsKey(player.getName())){
			if(Froggles.trackingmap.get(player.getName())){
				Player tracked = com.frogman786.froggles.utils.Tracking.getNearest(player);
				player.setCompassTarget(tracked.getLocation());
			}
		}
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
}
