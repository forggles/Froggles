package com.frogman786.froggles;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Events implements Listener {
	@EventHandler // TODO Tidy later, it's better now anyway
	public void onPlayerJoin(PlayerJoinEvent evt) {
	    Player player = evt.getPlayer();
	    Enum<ChatColor> colour = ChatColor.YELLOW;
	    String plural = " players";
	    if(Bukkit.getOnlinePlayers().length == 1){
	    	plural = " player";
	    }
	    if(player.hasPermission("nametags.color.dark_blue")){
	    	colour = ChatColor.DARK_BLUE;
	    }else{
	    	if(player.hasPermission("nametags.color.dark_green")){
		    	colour = ChatColor.DARK_GREEN;
		    }else{
		    	if(player.hasPermission("nametags.color.gold")){
		    		colour = ChatColor.GOLD;
			    }else{
			    	if(player.hasPermission("nametags.color.blue")){
			    		colour = ChatColor.BLUE;
				    }else{
				    	if(player.hasPermission("nametags.color.green")){
				    		colour = ChatColor.GREEN;
					    }else{
					    	if(player.hasPermission("nametags.color.aqua")){
					    		colour = ChatColor.AQUA;
						    }else{
						    	if(player.hasPermission("nametags.color.red")){
						    		colour = ChatColor.RED;
							    }else{
							    	if(player.hasPermission("nametags.color.light_purple")){
							    		colour = ChatColor.LIGHT_PURPLE;
								    }
							    }
						    }
					    }
				    }
			    }
		    }
		}
	    evt.setJoinMessage(colour + player.getName() + ChatColor.WHITE + " logged in, making " + ChatColor.RED + Bukkit.getOnlinePlayers().length + ChatColor.GREEN + plural);
	}
	@EventHandler // TODO same here
	public void onPlayerQuit(PlayerQuitEvent evt) {
	    Player player = evt.getPlayer();
	    Enum<ChatColor> colour = ChatColor.YELLOW;
	    String plural = " players";
	    if(Bukkit.getOnlinePlayers().length-1 == 1){
	    	plural = " player";
	    }
	    if(player.hasPermission("nametags.color.dark_blue")){
	    	colour = ChatColor.DARK_BLUE;
	    }else{
	    	if(player.hasPermission("nametags.color.dark_green")){
		    	colour = ChatColor.DARK_GREEN;
		    }else{
		    	if(player.hasPermission("nametags.color.gold")){
		    		colour = ChatColor.GOLD;
			    }else{
			    	if(player.hasPermission("nametags.color.blue")){
			    		colour = ChatColor.BLUE;
				    }else{
				    	if(player.hasPermission("nametags.color.green")){
				    		colour = ChatColor.GREEN;
					    }else{
					    	if(player.hasPermission("nametags.color.aqua")){
					    		colour = ChatColor.AQUA;
						    }else{
						    	if(player.hasPermission("nametags.color.red")){
						    		colour = ChatColor.RED;
							    }else{
							    	if(player.hasPermission("nametags.color.light_purple")){
							    		colour = ChatColor.LIGHT_PURPLE;
								    }
							    }
						    }
					    }
				    }
			    }
		    }
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
