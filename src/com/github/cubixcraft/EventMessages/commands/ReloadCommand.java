package com.github.cubixcraft.EventMessages.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.github.cubixcraft.EventMessages.EventMessages;
import com.github.cubixcraft.EventMessages.extras.TextUtil;

public class ReloadCommand implements CommandExecutor {
	private EventMessages plugin;
	
	public ReloadCommand(EventMessages plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		this.plugin.reloadConfig();
		sender.sendMessage(TextUtil.format(
			this.plugin.getConfig().getString("strings.reloaded")
		));
		return true;
	}
}
