package com.github.cubixcraft.EventMessages;

import java.io.File;
import java.io.IOException;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.cubixcraft.EventMessages.commands.Router;
import com.github.cubixcraft.EventMessages.extras.Metrics;


public class EventMessages extends JavaPlugin {

	public static String name;
	public static String version;
	public Permission permission = null;

	@Override
	public void onEnable() {
		File file = new File(getDataFolder() + File.separator + "config.yml");
		PluginManager pm = getServer().getPluginManager();
		
		name = getDescription().getName();
		version = getDescription().getVersion();
		
		// Write configuration file, if it doesn't exist
		if(!file.exists()) {
			getLogger().info("Generating configuration");
			getConfig().options().header("For configuration help see: https://www.github.com/CubixCraft/EventMessages");
			getConfig().addDefault("strings.reloaded", "&a>&f Reloaded EventMessages.");
			getConfig().addDefault("strings.configSet", "&a>&f Set EventMessage for &6%event&f to &6'&r%message&6'&f.");
			getConfig().addDefault("strings.configUnset", "&a>&f Removed EventMessage for &6%event&f.");
			getConfig().addDefault("messages.player.join", "&6>&f %player is &aonline&f.");
			getConfig().addDefault("messages.player.quit", "&6>&f %player is &coffline&f.");
			getConfig().addDefault("messages.player.kick", "&6>&f %player was &ckicked&f.");
			getConfig().addDefault("messages.player.ban", "&6>&f %player was &4banned&f.");
			getConfig().addDefault("messages.player.death", "&6>&f %player died.");
			getConfig().options().copyDefaults(true);
			saveConfig();
			reloadConfig();
		}
		
		// Register all events
		pm.registerEvents(new EventListener(this), this);
		
		// Register commands
		getCommand("EventMessages").setExecutor(new Router(this));
		
		// Startup Metrics
		try {
		    Metrics metrics = new Metrics(this);
		    getLogger().info("Enabling Metrics");
		    metrics.start();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

	@Override
	public void onDisable() {

	}
}
