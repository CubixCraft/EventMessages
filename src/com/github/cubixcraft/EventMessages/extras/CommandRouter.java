package com.github.cubixcraft.EventMessages.extras;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class CommandRouter implements CommandExecutor {
	private Map<String, String> routes = new HashMap<String, String>(); 
	private JavaPlugin plugin;
	
	public CommandRouter(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	public CommandRouter() {}
	
	public void registerRoute(String argument, String route) {
		this.routes.put(argument, route);
	}
	public void registerRoutes(Map<String, String> routes) {
		this.routes.putAll(routes);
	}
	public void registerRoute(Map<String, String> routes) {
		this.registerRoutes(routes);
	}
	public void registerCommand(String command, CommandExecutor executor, String alias) {
		try {
			plugin.getCommand(command).setExecutor(executor);
			this.registerRoute(alias, command);
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length > 0 && this.routes.containsKey(args[0])) {
			if(args.length > 1) {
				sender.getServer().dispatchCommand(sender, this.routes.get(args[0]) + " " + TextUtil.join(args, 1, " "));
			} else {
				sender.getServer().dispatchCommand(sender, this.routes.get(args[0]));
			}
			return true;
		}
		return false;
	}

}
