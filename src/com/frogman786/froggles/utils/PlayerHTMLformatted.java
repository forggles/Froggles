package com.frogman786.froggles.utils;

import java.io.*;

import org.bukkit.entity.Player;

public class PlayerHTMLformatted {

	private static String location = "plugins/Froggles/online.txt";
	public static void refreshList(Player[] parry){
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter(location));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		for(Player listplayer:parry){
			out.print("<div style=\"color:"+getTag(listplayer)+";font-size:18\">"+listplayer.getName()+"</div> ");
		}
		out.close();
	}
	
	private static String getTag(Player p) {
		//checking colour perms
		if(p.hasPermission("nametags.color.black")){
			return "#0000";
		}else{
			if(p.hasPermission("nametags.color.dark_blue")){
				return "#00002A";
			}else{
				if(p.hasPermission("nametags.color.dark_green")){
					return "#002A00";
				}else{
					if(p.hasPermission("nametags.color.dark_aqua")){
						return "#002A2A";
					}else{
						if(p.hasPermission("nametags.color.dark_red")){
							return "#2A0000";
						}else{
							if(p.hasPermission("nametags.color.dark_purple")){
								return "#2A002A";
							}else{
								if(p.hasPermission("nametags.color.gold")){
									return "#2A2A00";
								}else{
									if(p.hasPermission("nametags.color.gray")){
										return "#2A2A2A";
									}else{
										if(p.hasPermission("nametags.color.dark_gray")){
											return "#151515";
										}else{
											if(p.hasPermission("nametags.color.blue")){
												return "#15153F";
											}else{
												if(p.hasPermission("nametags.color.green")){
													return "#153F15";
												}else{
													if(p.hasPermission("nametags.color.aqua")){
														return "#153F3F";
													}else{
														if(p.hasPermission("nametags.color.red")){
															return "#3F1515";
														}else{
															if(p.hasPermission("nametags.color.light_purple")){
																return "#3F153F";
															}else{
																if(p.hasPermission("nametags.color.white")){
																	return "#3F3F3F";
																}else{
																	return "#FFFF55";
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
