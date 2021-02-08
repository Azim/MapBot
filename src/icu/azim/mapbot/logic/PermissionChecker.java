package icu.azim.mapbot.logic;

import java.util.HashSet;
import java.util.Set;

import icu.azim.mapbot.MapBotPlugin;

public class PermissionChecker {
	private Set<Long> fullrender = new HashSet<>();
	private Set<Long> render = new HashSet<>();
	private boolean enabled;
	
	public PermissionChecker(MapBotPlugin plugin) {
		enabled = plugin.getConfig().getBoolean("roles.enable", false);
		if(enabled) {
			fullrender = new HashSet<>(plugin.getConfig().getLongList("roles.fullrender"));
			render = new HashSet<>(plugin.getConfig().getLongList("roles.render"));
		}
	}
	public synchronized boolean hasPermissionFull(Long id) {
		return fullrender.contains(id)||!enabled;
	}
	public synchronized boolean hasPermissionLocal(Long id) {
		return render.contains(id)||!enabled;
	}
}
