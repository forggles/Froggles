package com.frogman786.froggles;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
//import org.bukkit.entity.Entity;
//import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
//import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Vector;

import com.frogman786.froggles.utils.Chat;
import com.frogman786.froggles.utils.VelocityUtil;
import com.frogman786.froggles.utils.filter;
import com.frogman786.froggles.utils.voxelarrowhelper;
//import com.frogman786.froggles.utils.netherdoor;

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
		if(Froggles.freezemap.containsKey(player.getName())){
			evt.setCancelled(true);
		}
		//Bukkit.broadcastMessage("move fire");
		//if(netherdoor.check(player)){
			//Bukkit.broadcastMessage("check pass");
			//if(netherdoor.complete(player)){
				//Bukkit.broadcastMessage("complete passed");
			//}else{
				//evt.setCancelled(true);
				//player.sendMessage(ChatColor.RED+"you need to finish the door before you can pass");
				//Location backspace = player.getLocation();
				//Bukkit.broadcastMessage("location is" +backspace.toString());
				//backspace.setX(backspace.getX()-2);
				//Bukkit.broadcastMessage("changed to" + backspace.toString());
				//boolean tp = false;
				//Entity tplocation = player.getWorld().spawnEntity(backspace, EntityType.PIG_ZOMBIE);
				//tp = player.teleport(tplocation);
				
				//Bukkit.broadcastMessage(""+tp);
			//}
		//}
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent evt) {
	    Player player = evt.getPlayer();
	    Enum<?> colour = Chat.getRankColour(player);
	    String plural = " players";
	    if(Bukkit.getOnlinePlayers().size() == 1){
	    	plural = " player";
	    }
	    
	    evt.setJoinMessage(colour + player.getName() + ChatColor.WHITE + " logged in, making " + ChatColor.RED + Bukkit.getOnlinePlayers().size() + ChatColor.GREEN + plural);
	}
	
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent evt) {
	    Player player = evt.getPlayer();
	    Enum<?> colour = Chat.getRankColour(player);
	    String plural = " players";
	    if(Bukkit.getOnlinePlayers().size()-1 == 1){
	    	plural = " player";
	    }
	    
	    evt.setQuitMessage(colour + player.getName() + ChatColor.WHITE + " quit, " + ChatColor.RED + (Bukkit.getOnlinePlayers().size() - 1) + ChatColor.GREEN + plural + ChatColor.WHITE + " left");
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
	//@EventHandler
	//public void onZombieSight(EntityTargetLivingEntityEvent evt){
	//	String seen = evt.getTarget().toString();
	//	String saw = evt.getEntityType().toString();
	//	if(Froggles.zom_vill_safe==true&&seen=="CraftVillager"&&saw=="ZOMBIE"){
	//		evt.setCancelled(true);
	//	}
	//}
	
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
	
	@EventHandler
	public void arrowshoot(EntityShootBowEvent evt){
		if(evt.getEntity() instanceof Player){
			Player p = (Player) evt.getEntity();
			String pn = p.getDisplayName().toLowerCase();
			if(Froggles.bouncingbullets.contains(pn)){
				Projectile pro = (Arrow) evt.getProjectile();
				pro.setCustomName("bullet"+ p.getDisplayName());
			}
			if(Froggles.voxelbullets.contains(pn)){
				Projectile pro = (Arrow) evt.getProjectile();
				pro.setCustomName("voxel");
			}
			if(Froggles.rodeobullets.contains(pn)){
				Projectile pro = (Arrow) evt.getProjectile();
				Entity ball = pro.getWorld().spawnEntity(pro.getLocation(), EntityType.SNOWBALL);
				ball.setVelocity(pro.getVelocity());
				ball.setPassenger(p);
				pro.remove();
			}
		}
	}
	
	@EventHandler
	public void arrowhit(ProjectileHitEvent evt){
		try {
			String bulletname = evt.getEntity().getCustomName();
			if(bulletname.startsWith("bullet")){
				Projectile pro = evt.getEntity();
				Location currentlocation = pro.getLocation();
				Location returnlocation = Bukkit.getPlayer(pro.getCustomName().substring(6)).getLocation();
				Vector v = VelocityUtil.twopoints(currentlocation,returnlocation);
				currentlocation.getWorld().spawnArrow(currentlocation, v, (float) 3, (float) 0);
				pro.remove();
			}
			if(bulletname.startsWith("voxel")){
				Projectile pro = evt.getEntity();
				Location currentlocation = pro.getLocation();
				voxelarrowhelper.toglass(currentlocation, 3);
				pro.remove();
			}
		} catch (NullPointerException nu) {
			//do nothin'
		}
	}
}