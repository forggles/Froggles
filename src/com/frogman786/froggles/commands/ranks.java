package com.frogman786.froggles.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.frogman786.froggles.Froggles;
import com.frogman786.froggles.utils.Chat;

public class ranks implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		//import strings
		StringBuilder messagebuilder = new StringBuilder();
		for(String word:Froggles.rankslist){
			messagebuilder.append(word+"\n");
		}
		//parse colours
		String messagefinal = Chat.formatmessage(messagebuilder.toString());
		//send
		sender.sendMessage(messagefinal);
		return true;
	}

}
