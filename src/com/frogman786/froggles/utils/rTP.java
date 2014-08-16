package com.frogman786.froggles.utils;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class rTP {

	public static void rtp(Player target, int x1, int x2, int y1, int y2, int safey) {
		World world = target.getWorld();
		int x = randInt(x1,x2);
		int z = randInt(y1,y2);
		int y = getSafeY(target.getWorld(), x,z, safey);
		target.teleport(new Location(world, x, y, z));
	}
	
	
	// for finding a safe height at x*z 
	public static int getSafeY(World world, int x, int y, int safey){
		for (int i = safey; i > 0; i--){
		    Material mat = world.getBlockAt(x, i, y).getType();
		    if(mat != Material.AIR){
		    	safey = i+2;
		    	break;
		    }
		}
		return safey;
	}

	//for generating the random number with a min and max
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}

}
