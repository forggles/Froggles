package com.frogman786.froggles.utils;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.frogman786.froggles.Froggles;



public class filter {
	public static boolean swears(String message){
		for(String word:Froggles.swears){
			if(message.contains(word)){
				return false;
			}
		}
		return true;
	}
	
	public static String nomessage(){
		String[] mess = {"tone down that language",
				"no swear swear",
				"no swear swear, rudeness is bad",
				"swearing is bad no swear swear",
				"count to 10 and rethink what you said"};
		Random rand = new Random();
	    int randomNum = rand.nextInt((4 - 0) + 1) + 0;
	    return mess[randomNum];
	}
	
	public static void notify(Player player, String message){
		for(Player lp: Bukkit.getOnlinePlayers()){
			if(lp.hasPermission("frog.filter.notify")){
				lp.sendMessage(Chat.getRankColour(player)+player.getName()+ChatColor.WHITE+" Tried to say: "+message);
			}
		}
	}
}
