package com.frogman786.froggles.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import com.frogman786.froggles.Froggles;

public class trackingarrowhelper {
	
	public static Player findtarget(Location loc){
		for(Player p : Bukkit.getOnlinePlayers()){
			if(p.getLocation().distance(loc) < 10){
				return p;
			}
		}
		return null;
	}
	
	public static void firstdelayer(final Location point){
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
    	scheduler.scheduleSyncDelayedTask(Froggles.getPlugin(), new Runnable() {
        	@Override
        	public void run() {
            	
        	}
    	}, 10L);
	}
}
