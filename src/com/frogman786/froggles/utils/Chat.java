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
}