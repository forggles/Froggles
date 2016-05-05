package com.frogman786.froggles.utils;

import java.io.*;
import java.util.Collection;

import org.bukkit.entity.Player;
import org.kitteh.vanish.VanishCheck;
import org.kitteh.vanish.VanishManager;

import com.frogman786.froggles.Froggles;

@SuppressWarnings("unused")
public class PlayerHTMLformatted {

	private static String location = "plugins/Froggles/online.txt";
	public static void refreshList(Collection<? extends Player> parry){
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter(location));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		for(Player listplayer:parry){
			if(false){//VanishManager.isVanished(listplayer)){
				
			}else{
			out.print(Froggles.colourmap.get("colours.beforeid")+getTag(listplayer)+Froggles.colourmap.get("colours.afterid")+listplayer.getName()+Froggles.colourmap.get("colours.aftername"));
			}
		}
		out.close();
	}
	
	private static String getTag(Player p) {
		//checking colour perms
		if(p.hasPermission("nametags.color.black")){
			return Froggles.colourmap.get("colours.black");
		}else{
			if(p.hasPermission("nametags.color.dark_blue")){
				return Froggles.colourmap.get("colours.dark_blue");
			}else{
				if(p.hasPermission("nametags.color.dark_green")){
					return Froggles.colourmap.get("colours.dark_green");
				}else{
					if(p.hasPermission("nametags.color.dark_aqua")){
						return Froggles.colourmap.get("colours.dark_aqua");
					}else{
						if(p.hasPermission("nametags.color.dark_red")){
							return Froggles.colourmap.get("colours.dark_red");
						}else{
							if(p.hasPermission("nametags.color.dark_purple")){
								return Froggles.colourmap.get("colours.dark_purple");
							}else{
								if(p.hasPermission("nametags.color.gold")){
									return Froggles.colourmap.get("colours.gold");
								}else{
									if(p.hasPermission("nametags.color.gray")){
										return Froggles.colourmap.get("colours.gray");
									}else{
										if(p.hasPermission("nametags.color.dark_gray")){
											return Froggles.colourmap.get("colours.dark_gray");
										}else{
											if(p.hasPermission("nametags.color.blue")){
												return Froggles.colourmap.get("colours.blue");
											}else{
												if(p.hasPermission("nametags.color.green")){
													return Froggles.colourmap.get("colours.green");
												}else{
													if(p.hasPermission("nametags.color.aqua")){
														return Froggles.colourmap.get("colours.aqua");
													}else{
														if(p.hasPermission("nametags.color.red")){
															return Froggles.colourmap.get("colours.red");
														}else{
															if(p.hasPermission("nametags.color.light_purple")){
																return Froggles.colourmap.get("colours.light_purple");
															}else{
																if(p.hasPermission("nametags.color.white")){
																	return Froggles.colourmap.get("colours.white");
																}else{
																	return Froggles.colourmap.get("colours.yellow");
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
