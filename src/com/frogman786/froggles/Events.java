package com.frogman786.froggles;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.frogman786.froggles.utils.Chat;
import com.frogman786.froggles.utils.filter;
import com.frogman786.froggles.utils.netherdoor;

public class Events implements Listener {
	@EventHandler (priority = EventPriority.LOWEST)
	public void onPlayerChat(AsyncPlayerChatEvent event){
		Player player = event.getPlayer();
		String message = event.getMessage();
		if(!(filter.swears(message))){
			if(!(player.hasPermission("frog.filter.bypass"))){
			event.setCancelled(true);
			player.sendMessage(filter.nomessage());
			filter.notify(player, message);
			}
		}
		if(Froggles.rainbowmap.containsKey(player.getName())&&Froggles.rainbowmap.get(player.getName())){
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
		//TODO stub for netherdoor check
		if(netherdoor.check(player)){
			if(netherdoor.complete(player)){
				
			}else{
				evt.setCancelled(true);
				player.sendMessage(ChatColor.RED+"you need to finish the door before you can pass");
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
	@EventHandler
	public void onBlockTouch(BlockBreakEvent evt){
		Player player = evt.getPlayer();
		if(player.hasPermission("frog.blocks.blacklist")){
			evt.setCancelled(false);
			player.sendMessage("block is: "+evt.getBlock().getType().name());
		}else{
			//evt.getBlock().getType().name())
			//player.sendMessage(ChatColor.RED+"ERROR: you cannot break this block");
			//evt.setCancelled(true);
		}
	}
	@EventHandler
	public void onZombieSight(EntityTargetLivingEntityEvent evt){
		String seen = evt.getTarget().toString();
		String saw = evt.getEntityType().toString();
		if(Froggles.zom_vill_safe==true&&seen=="CraftVillager"&&saw=="ZOMBIE"){
			evt.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent evt){
		Player player = evt.getPlayer();
		String playern = player.getName();
		if(Froggles.spawnmapx.containsKey(playern)){
			int x = Froggles.spawnmapx.get(playern);
			int y = Froggles.spawnmapy.get(playern);
			int z = Froggles.spawnmapz.get(playern);
			World world = player.getWorld();
			evt.setRespawnLocation(new Location(world,x,y,z));
		}
	}
}
