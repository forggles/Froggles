package com.frogman786.froggles.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import com.frogman786.froggles.Froggles;

public class netherdoor {
	
	
	public static boolean check(Player p){//I have absolutly no clue if this will work or not
		for(String word: Froggles.netherdoor){
			int playerx = (int) p.getLocation().getX();
			int playery = (int) p.getLocation().getY();
			int playerz = (int) p.getLocation().getZ();
			boolean doorIsX = false;
			Location atdoor = parsedoor(word);
			Block checkx = atdoor.add(3, 0, 0).getBlock();
			if(checkx.getType() == Material.BEDROCK){
				doorIsX = true;
			}
			if(playery <= (atdoor.getY()+2) && playery >= (atdoor.getY()-2)){
				if(doorIsX){
					if(playerz == atdoor.getZ()){
						if(playerx <= (atdoor.getX()+2) && playerx >= (atdoor.getX()-2){
							return true;
						}
					}
				}else{
					if(playerx == atdoor.getX()){
						if(playerz <= (atdoor.getZ()+2) && playerz >= (atdoor.getZ()-2){
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public static boolean complete(Player p) {
		for(String word: Froggles.netherdoor){
			Location atdoor = parsedoor(word);
			if(atdoor.distance(p.getLocation())<3){
				if(atdoor.getBlock().getType()==Material.PORTAL){
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}
	
	public static Location parsedoor(String s) {
		World world = null;
		int x = 0;
		int y = 0;
		int z = 0;
		String[] firstsplit = s.split(",");
		world = Bukkit.getWorld(firstsplit[0]);
		String[] secondsplit = firstsplit[1].split(",");
		x = Integer.parseInt(secondsplit[0]);
		String[] thirdsplit = secondsplit[1].split(",");
		y = Integer.parseInt(thirdsplit[0]);
		String[] forthsplit = thirdsplit[1].split(",");
		z = Integer.parseInt(forthsplit[0]);
		return new Location(world, x, y, z);
	}
}
