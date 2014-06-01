package com.frogman786.froggles.utils;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class rChest {
	public static ItemStack[] getRandomContents(int tier){
		ItemStack[] finalchest = new ItemStack[27];
		ItemStack[] tierg = null;
		ItemStack[] tier1 = {new ItemStack(Material.WOOD_AXE, 1),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5)};
		ItemStack[] tier2 = {new ItemStack(Material.WOOD_AXE, 1),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5)};
		ItemStack[] tier3 = {new ItemStack(Material.WOOD_AXE, 1),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5),
				new ItemStack(Material.ARROW, 5)};

		if(tier==1){
			tierg = tier1;
		}
		if(tier==2){
			tierg = tier2;
		}
		if(tier==3){
			tierg = tier3;
		}
		Random rand = new Random();
	    int randomAmmount = rand.nextInt((8 - 0) + 1) + 0;
	    for(int i=0;i<randomAmmount;i++){
		    int randomSlot = rand.nextInt((26 - 0) + 1) + 0;
		    int randomItem = rand.nextInt((19 - 0) + 1) + 0;
		    finalchest[randomSlot] = tierg[randomItem];
	    }
		return null;
		
	}
}
