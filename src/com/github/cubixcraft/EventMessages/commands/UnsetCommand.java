package com.github.cubixcraft.EventMessages.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.github.cubixcraft.EventMessages.EventMessages;
import com.github.cubixcraft.EventMessages.extras.TextUtil;

public class UnsetCommand implements CommandExecutor {
	private EventMessages plugin;
	
	public UnsetCommand(EventMessages plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(args.length == 1) {
			this.plugin.getConfig().set("messages." + args[0], null);
			this.plugin.saveConfig();
			sender.sendMessage(TextUtil.format(
				this.plugin.getConfig().getString("strings.configUnset")
				.replace("%event", args[0])
			));
			return true;
		}
		return false;
	}
}
