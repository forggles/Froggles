package com.frogman786.froggles.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class colours implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2,String[] arg3) {
			sender.sendMessage(ChatColor.BLUE + "-----" + ChatColor.DARK_GREEN + " Minecraft Text Colour Codes " + ChatColor.BLUE + "----");
			sender.sendMessage(ChatColor.WHITE + "-0 = " + ChatColor.BLACK + "BLACK");
			sender.sendMessage(ChatColor.WHITE + "-1 = " + ChatColor.DARK_BLUE + "DARK BLUE");
			sender.sendMessage(ChatColor.WHITE + "-2 = " + ChatColor.DARK_GREEN + "DARK GREEN");
			sender.sendMessage(ChatColor.WHITE + "-3 = " + ChatColor.DARK_AQUA + "DARK AQUA");
			sender.sendMessage(ChatColor.WHITE + "-4 = " + ChatColor.DARK_RED + "DARK RED");
			sender.sendMessage(ChatColor.WHITE + "-5 = " + ChatColor.DARK_PURPLE + "DARK PURPLE");
			sender.sendMessage(ChatColor.WHITE + "-6 = " + ChatColor.GOLD + "GOLD");
			sender.sendMessage(ChatColor.WHITE + "-7 = " + ChatColor.GRAY + "GRAY");
			sender.sendMessage(ChatColor.WHITE + "-8 = " + ChatColor.DARK_GRAY + "DARK GRAY");
			sender.sendMessage(ChatColor.WHITE + "-9 = " + ChatColor.BLUE + "BLUE");
			sender.sendMessage(ChatColor.WHITE + "-a = " + ChatColor.GREEN + "GREEN");
			sender.sendMessage(ChatColor.WHITE + "-b = " + ChatColor.AQUA + "AQUA");
			sender.sendMessage(ChatColor.WHITE + "-c = " + ChatColor.RED + "RED");
			sender.sendMessage(ChatColor.WHITE + "-d = " + ChatColor.LIGHT_PURPLE + "LIGHT PURPLE");
			sender.sendMessage(ChatColor.WHITE + "-e = " + ChatColor.YELLOW + "YELLOW");
			sender.sendMessage(ChatColor.WHITE + "-f = " + ChatColor.WHITE + "WHITE");
			sender.sendMessage(ChatColor.WHITE + "-k = " + ChatColor.MAGIC + "MAGIC");
			sender.sendMessage(ChatColor.WHITE + "-l = " + ChatColor.BOLD + "BOLD");
			sender.sendMessage(ChatColor.WHITE + "-m = " + ChatColor.STRIKETHROUGH + "STRIKETHROUGH"); 
			sender.sendMessage(ChatColor.WHITE + "-n = " + ChatColor.UNDERLINE + "UNDERLINE");
			sender.sendMessage(ChatColor.WHITE + "-o = " + ChatColor.ITALIC + "ITALIC");
			return true;
	}

}
