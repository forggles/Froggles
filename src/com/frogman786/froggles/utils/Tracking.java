package com.frogman786.froggles.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Tracking {
	public static Player getNearest(Player p){
		double closest = Double.MAX_VALUE;
		Player closestp = null;
		for(Player i : Bukkit.getOnlinePlayers()){
			if(!(i.isSneaking()) && i!=p){ // TODO add a hashmap config check on this one so sneaking can be enabled/disabled
			double dist = i.getLocation().distance(p.getPlayer().getLocation());
				if (closest == Double.MAX_VALUE || dist < closest){
					closest = dist;
					closestp = i;
				}
			}
		}
		if (closestp == null){
		  return p;
		}
		else{
		  return closestp;
		}
	}
	public static double getNearestDistance(Player p){
		double closest = Double.MAX_VALUE;
		for(Player i : Bukkit.getOnlinePlayers()){
			if(!(i.isSneaking()) && i!=p){ // TODO add a hashmap config check on this one so sneaking can be enabled/disabled
			double dist = i.getLocation().distance(p.getPlayer().getLocation());
				if (closest == Double.MAX_VALUE || dist < closest){
					closest = dist;
				}
			}
		}
		return closest;
	}
}
