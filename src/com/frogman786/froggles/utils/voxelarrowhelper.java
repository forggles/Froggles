package com.frogman786.froggles.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

import com.frogman786.froggles.Froggles;

public class voxelarrowhelper {

	public static void toglass(Location point, int r){
		Location pointu = point;
	    for(int x = (r * -1); x <= r; x++) {
	        for(int y = (r * -1); y <= r; y++) {
	            for(int z = (r * -1); z <= r; z++) {
	                Block b = pointu.getWorld().getBlockAt(pointu.getBlockX() + x, pointu.getBlockY() + y, pointu.getBlockZ() + z);
	                if(b.getType() == Material.AIR){
	                    b.setType(Material.GLASS);
	                }
	            }
	        }
	    }
	    toair(point,2);
	    delayer(point, r);
	    
	}
	public static void toair(Location point, int r){
		Location pointu = point;
	    for(int x = (r * -1); x <= r; x++) {
	        for(int y = (r * -1); y <= r; y++) {
	            for(int z = (r * -1); z <= r; z++) {
	                Block b = pointu.getWorld().getBlockAt(pointu.getBlockX() + x, pointu.getBlockY() + y, pointu.getBlockZ() + z);
	                if(b.getType() == Material.GLASS){
	                    b.setType(Material.AIR);
	                }
	            }
	        }
	    }
	}
	
	private static void delayer(final Location point,final int r){
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
    	scheduler.scheduleSyncDelayedTask(Froggles.getPlugin(), new Runnable() {
        	@Override
        	public void run() {
            	toair(point, r);
        	}
    	}, 60L);
	}
}
