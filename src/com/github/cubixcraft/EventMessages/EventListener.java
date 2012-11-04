package com.github.cubixcraft.EventMessages;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.github.cubixcraft.EventMessages.EventMessages;
import com.github.cubixcraft.EventMessages.extras.TextUtil;

public class EventListener implements Listener {
	private EventMessages plugin;
	
	public EventListener(EventMessages plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		String message = plugin.getConfig().getString("messages.player.join");
		
		if(message != null) {
			message = TextUtil.format(
				message
				.replace("%player", event.getPlayer().getName())
				.replace("%playerColor", event.getPlayer().getDisplayName())
			);
		}
		
		event.setJoinMessage(message);
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		String message = plugin.getConfig().getString("messages.player.quit");
		
		if(message != null) {
			message = TextUtil.format(
				message
				.replace("%player", event.getPlayer().getName())
				.replace("%playerColor", event.getPlayer().getDisplayName())
			);
		}
		
		event.setQuitMessage(message);
	}

	@EventHandler
	public void onPlayerKick(PlayerKickEvent event) {
		String message;
		if(event.getPlayer().isBanned()) {
			message = plugin.getConfig().getString("messages.player.ban");
		} else {
			message = plugin.getConfig().getString("messages.player.kick");
		}
		
		if(message != null) {
			message = TextUtil.format(
				message
				.replace("%player", event.getPlayer().getName())
				.replace("%playerColor", event.getPlayer().getDisplayName())
				.replace("%reason", event.getReason())
			);
		}
		
		event.setLeaveMessage(message);
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		String message = this.plugin.getConfig().getString("messages.player.death");
		
		/*
		Player killer = event.getEntity().getKiller();
		DamageCause damage = event.getEntity().getLastDamageCause().getCause();
		
		if(killer != null) {
			message = this.plugin.getConfig().getString("messages.player.death.player");
		} else {
			message = this.plugin.getConfig().getString("messages.player.death." + damage.toString());
		}
		
		if(message == null) {
			message = this.plugin.getConfig().getString("messages.player.death.default");
		}
		*/
		
		if(message != null) {
			event.setDeathMessage(
				TextUtil.format(
					message
					.replace("%player", event.getEntity().getName())
					.replace("%playerColor", event.getEntity().getDisplayName())
					/*
					.replace("%killer", killer != null ? killer.getName() : "")
					.replace("%killerColor", killer != null ? killer.getDisplayName() : "")
					*/
				)
			);
		} else {
			event.setDeathMessage(null);
		}
	}
}
