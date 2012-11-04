package com.github.cubixcraft.EventMessages.extras;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.event.entity.PlayerDeathEvent;

public class EventProcessor {
	public Map<String, Object> onPlayerDeath(PlayerDeathEvent event) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		// get player
		result.put("player", event.getEntity());
		
		
		
		
		return result;
	}
}
