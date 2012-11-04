package com.github.cubixcraft.EventMessages.commands;

import com.github.cubixcraft.EventMessages.EventMessages;
import com.github.cubixcraft.EventMessages.extras.CommandRouter;

public class Router extends CommandRouter {
	public Router(EventMessages plugin) {
		super(plugin);
		registerCommand("emreload", new ReloadCommand(plugin), "reload");
		registerCommand("emset", new SetCommand(plugin), "set");
		registerCommand("emunset", new UnsetCommand(plugin), "unset");
	}
}
