package com.frogman786.froggles.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Chat {
	
	public static Enum<?> getRankColour(Player p){
		if(p.hasPermission("nametags.color.black")){
			return ChatColor.BLACK;
		}else{
			if(p.hasPermission("nametags.color.dark_blue")){
				return ChatColor.DARK_BLUE;
			}else{
				if(p.hasPermission("nametags.color.dark_green")){
					return ChatColor.DARK_GREEN;
				}else{
					if(p.hasPermission("nametags.color.dark_aqua")){
						return ChatColor.DARK_AQUA;
					}else{
						if(p.hasPermission("nametags.color.dark_red")){
							return ChatColor.DARK_RED;
						}else{
							if(p.hasPermission("nametags.color.dark_purple")){
								return ChatColor.DARK_PURPLE;
							}else{
								if(p.hasPermission("nametags.color.gold")){
									return ChatColor.GOLD;
								}else{
									if(p.hasPermission("nametags.color.gray")){
										return ChatColor.GRAY;
									}else{
										if(p.hasPermission("nametags.color.dark_gray")){
											return ChatColor.DARK_GRAY;
										}else{
											if(p.hasPermission("nametags.color.blue")){
												return ChatColor.BLUE;
											}else{
												if(p.hasPermission("nametags.color.green")){
													return ChatColor.GREEN;
												}else{
													if(p.hasPermission("nametags.color.aqua")){
														return ChatColor.AQUA;
													}else{
														if(p.hasPermission("nametags.color.red")){
															return ChatColor.RED;
														}else{
															if(p.hasPermission("nametags.color.light_purple")){
																return ChatColor.LIGHT_PURPLE;
															}else{
																if(p.hasPermission("nametags.color.white")){
																	return ChatColor.WHITE;
																}else{
																	return ChatColor.YELLOW;
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	public static String formatmessage(String message){
		char ColourSymbol = '\u00A7';
		message = message.replaceAll("&0", ColourSymbol + "0");
		message = message.replaceAll("&1", ColourSymbol + "1");
		message = message.replaceAll("&2", ColourSymbol + "2");
		message = message.replaceAll("&3", ColourSymbol + "3");
		message = message.replaceAll("&4", ColourSymbol + "4");
		message = message.replaceAll("&5", ColourSymbol + "5");
		message = message.replaceAll("&6", ColourSymbol + "6");
		message = message.replaceAll("&7", ColourSymbol + "7");
		message = message.replaceAll("&8", ColourSymbol + "8");
		message = message.replaceAll("&9", ColourSymbol + "9");
		message = message.replaceAll("&a", ColourSymbol + "a");
		message = message.replaceAll("&b", ColourSymbol + "b");
		message = message.replaceAll("&c", ColourSymbol + "c");
		message = message.replaceAll("&d", ColourSymbol + "d");
		message = message.replaceAll("&e", ColourSymbol + "e");
		message = message.replaceAll("&f", ColourSymbol + "f");
		message = message.replaceAll("&l", ColourSymbol + "l");
		message = message.replaceAll("&m", ColourSymbol + "m");
		message = message.replaceAll("&n", ColourSymbol + "n");
		message = message.replaceAll("&o", ColourSymbol + "o");
		message = message.replaceAll("&k", ColourSymbol + "k");
		return message;	
	}
	public static String getPrefix(Player player){
		String prefix = "";
		
		prefix = formatmessage(prefix);
		return prefix;
	}
}