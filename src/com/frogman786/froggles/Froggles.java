package com.frogman786.froggles;
 
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.frogman786.froggles.commands.gm;
import com.frogman786.froggles.commands.who;
import com.frogman786.froggles.commands.world;
import com.frogman786.froggles.commands.platform;
import com.frogman786.froggles.commands.time;
import com.frogman786.froggles.commands.pos;
 
public class Froggles extends JavaPlugin{
   
    private static Plugin plugin;
   
    public void onEnable() {
        plugin = this;
        registerEvents(this, new Events());
        getCommand("gm").setExecutor(new gm());
        getCommand("who").setExecutor(new who());
        getCommand("world").setExecutor(new world());
        getCommand("pos").setExecutor(new pos());
        getCommand("platform").setExecutor(new platform());
        getCommand("dawn").setExecutor(new time());
        getCommand("day").setExecutor(new time());
        getCommand("noon").setExecutor(new time());
        getCommand("dusk").setExecutor(new time());
        getCommand("night").setExecutor(new time());
    }
   
    public void onDisable() {
       
    }
    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
    public static Plugin getPlugin() {
        return plugin;
    }
   
   
   
 
}