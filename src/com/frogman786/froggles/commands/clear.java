package com.frogman786.froggles.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class clear implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if(lbl.equalsIgnoreCase("clr")){
			int allowlevel = 0;
			if(sender instanceof Player){
				Player player = (Player) sender;
				if(player.hasPermission("frog.clear.inventory.self")){
					allowlevel = 1;
				}
				if(player.hasPermission("frog.clear.inventory.other")){
					allowlevel = 2;
				}
			}else{
				allowlevel = 2;
			}
			if(allowlevel>=1){
				//command here
			}
		}else{
			//for clreff/cleareffect
			int allowlevel = 0;
			if(sender instanceof Player){
				Player player = (Player) sender;
				if(player.hasPermission("frog.clear.effect.self")){
					allowlevel = 1;
				}
				if(player.hasPermission("frog.clear.effect.other")){
					allowlevel = 2;
				}
			}else{
				allowlevel = 2;
			}
			if(allowlevel>=1){
				Player player = (Player) sender;
				player.removePotionEffect(PotionEffectType.ABSORPTION);
				player.removePotionEffect(PotionEffectType.BLINDNESS);
				player.removePotionEffect(PotionEffectType.CONFUSION);
				player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
				player.removePotionEffect(PotionEffectType.FAST_DIGGING);
				player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
				player.removePotionEffect(PotionEffectType.HARM);
				player.removePotionEffect(PotionEffectType.HEAL);
				player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
				player.removePotionEffect(PotionEffectType.HUNGER);
				player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				player.removePotionEffect(PotionEffectType.INVISIBILITY);
				player.removePotionEffect(PotionEffectType.JUMP);
				player.removePotionEffect(PotionEffectType.NIGHT_VISION);
				player.removePotionEffect(PotionEffectType.POISON);
				player.removePotionEffect(PotionEffectType.REGENERATION);
				player.removePotionEffect(PotionEffectType.SATURATION);
				player.removePotionEffect(PotionEffectType.SLOW);
				player.removePotionEffect(PotionEffectType.SLOW_DIGGING);
				player.removePotionEffect(PotionEffectType.SPEED);
				player.removePotionEffect(PotionEffectType.WATER_BREATHING);
				player.removePotionEffect(PotionEffectType.WEAKNESS);
				player.removePotionEffect(PotionEffectType.WITHER);
				return true;
				}
			return true;
			}
		return false;
		}
	}
