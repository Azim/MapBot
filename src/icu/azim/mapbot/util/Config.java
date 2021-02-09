package icu.azim.mapbot.util;

import org.bukkit.configuration.file.FileConfiguration;

import icu.azim.mapbot.MapBotPlugin;

public class Config {
	private int threads;
	private String prefix;
	private long cacheLifespan;
	private long refreshRate;
	private String defaultWorld;
	private boolean generateInvite;
	private int defaultSizeX, defaultSizeZ, maxSizeX, maxSizeZ;
	public Config(MapBotPlugin plugin) {
		FileConfiguration cfg = plugin.getConfig();
		threads = cfg.getInt("threads", 4);
		prefix = cfg.getString("bot.prefix", "m!");
		cacheLifespan = cfg.getLong("cacheinterval-ms", 300000);
		refreshRate = cfg.getLong("autorefresh", 18000);
		defaultWorld = cfg.getString("map.default-world", "world");
		defaultSizeX = cfg.getInt("map.default-size-x", 64);
		defaultSizeZ = cfg.getInt("map.default-size-z", 64);
		maxSizeX = cfg.getInt("map.max-size-x", 1000);
		maxSizeZ = cfg.getInt("map.max-size-z", 1000);
		generateInvite = cfg.getBoolean("bot.generate-invite", true);
	}
	public int getThreads() {
		return threads;
	}
	public String getPrefix() {
		return prefix;
	}
	public long getCacheLifespan() {
		return cacheLifespan;
	}
	public long getRefreshRate() {
		return refreshRate;
	}
	public String getDefaultWorld() {
		return defaultWorld;
	}
	public int getDefaultSizeX() {
		return defaultSizeX;
	}
	public int getDefaultSizeZ() {
		return defaultSizeZ;
	}
	public int getMaxSizeX() {
		return maxSizeX;
	}
	public int getMaxSizeZ() {
		return maxSizeZ;
	}
	public boolean doGenerateInvite() {
		return generateInvite;
	}
}
