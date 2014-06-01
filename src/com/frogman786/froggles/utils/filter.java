package com.frogman786.froggles.utils;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;



public class filter {
	private static String[] swears = {"shit","piss","fuck","cunt","cock","fucker","tits","turd","twat","bitch","whore","penis","vagina","dick","yingjang","gay","homo"};
	public static boolean swears(String message){
		for(String word:swears){
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
	    int randomNum = rand.nextInt((5 - 0) + 1) + 0;
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
