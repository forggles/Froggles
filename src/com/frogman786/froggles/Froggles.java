package com.frogman786.froggles;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.frogman786.froggles.commands.Announce;
import com.frogman786.froggles.commands.cfg;
import com.frogman786.froggles.commands.chest;
import com.frogman786.froggles.commands.filter;
import com.frogman786.froggles.commands.gm;
import com.frogman786.froggles.commands.rainbow;
import com.frogman786.froggles.commands.tracking;
import com.frogman786.froggles.commands.who;
import com.frogman786.froggles.commands.world;
import com.frogman786.froggles.commands.platform;
import com.frogman786.froggles.commands.time;
import com.frogman786.froggles.commands.pos;
//import com.frogman786.froggles.commands.ban;
import com.frogman786.froggles.commands.spleef;
import com.frogman786.froggles.commands.me;
import com.frogman786.froggles.commands.zombies;
import com.frogman786.froggles.commands.frogcommand;
import com.frogman786.froggles.commands.spawns;
 
public class Froggles extends JavaPlugin{
   
    private static Plugin plugin;
    public static Map<String, String> replymap = new HashMap<String, String>();
    public static Map<String, String> configmap = new HashMap<String, String>();
    public static Map<String,Boolean> trackingmap = new HashMap<String, Boolean>();
    public static Map<String,Boolean> rainbowmap = new HashMap<String, Boolean>();
    public static String[] bannedblocks = {"AIR"};
	public static boolean zom_vill_safe = false;
	public static boolean frogcommand = false;
	public static Map<String, Integer> spawnmapx = new HashMap<String,Integer>();
	public static Map<String, Integer> spawnmapy = new HashMap<String,Integer>();
	public static Map<String, Integer> spawnmapz = new HashMap<String,Integer>();
	public static List<String> swears = Collections.synchronizedList(new ArrayList<String>());
	public static List<String> swearmessage = Collections.synchronizedList(new ArrayList<String>());
	
    public void onEnable() {
        plugin = this;
        registerEvents(this, new Events());
        configini();
        commandini();
    }
   
    public void onDisable() {
       swearsaver();
    }
    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
    public static Plugin getPlugin() {
        return plugin;
    }
    
    private void configini(){
    	FileConfiguration config = getConfig();
		config.options().copyDefaults(true);
		saveConfig();
		for(String str: getConfig().getKeys(true)) {
			
			 if(str.startsWith("message")){
			String p = getConfig().getString(str);
			configmap.put(str, p);
			 }
		}
		for(String word: getConfig().getStringList("filter.swears")){
			swears.add(word);
		}
		for(String word: getConfig().getStringList("filter.messages")){
			swearmessage.add(word);
		}
    }
    
    private void swearsaver(){
    	FileConfiguration config = getConfig();
    	config.set("filter.swears", swears);
    	config.set("filter.messages", swearmessage);
		config.options().copyDefaults(true);
		saveConfig();
    }
    
    private void commandini(){
    	//gamemode
    	getCommand("gm").setExecutor(new gm());
    	//info
        getCommand("who").setExecutor(new who());
        getCommand("colourcodes").setExecutor(new com.frogman786.froggles.commands.colours());
        //info coords
        getCommand("world").setExecutor(new world());
        getCommand("pos").setExecutor(new pos());
        //platform
        getCommand("platform").setExecutor(new platform());
        //time
        getCommand("dawn").setExecutor(new time());
        getCommand("day").setExecutor(new time());
        getCommand("noon").setExecutor(new time());
        getCommand("dusk").setExecutor(new time());
        getCommand("night").setExecutor(new time());
        //kick/ban
        //getCommand("kick").setExecutor(new ban());
        //spleef
        getCommand("spleeflayer").setExecutor(new spleef());
        getCommand("cuboid").setExecutor(new spleef());
        //announce
        getCommand("me").setExecutor(new me());
        //pms
        getCommand("pms").setExecutor(new pms());
        getCommand("r").setExecutor(new pms());
        //compass
        getCommand("track").setExecutor(new tracking());
        getCommand("untrack").setExecutor(new tracking());
        //debugs
        getCommand("pmsdebug").setExecutor(new pms());
        getCommand("cfgdebug").setExecutor(new cfg());
        getCommand("trackdebug").setExecutor(new tracking());
        //announcements
        getCommand("announce").setExecutor(new Announce());
        getCommand("announcepromo").setExecutor(new Announce());
        //automatic text formatting
        getCommand("rainbowtext").setExecutor(new rainbow());
        //zombie protection
        getCommand("zombiesafety").setExecutor(new zombies());
        getCommand("frogcommand").setExecutor(new frogcommand());
        getCommand("gamespawn").setExecutor(new spawns());
        getCommand("randomchest").setExecutor(new chest());
        getCommand("chatfilter").setExecutor(new filter());
    }
   
   
   
 
}