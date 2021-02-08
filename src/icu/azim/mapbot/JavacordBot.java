package icu.azim.mapbot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import icu.azim.mapbot.logic.RenderCommand;

public class JavacordBot {
	
	public JavacordBot(MapBotPlugin plugin) {
		String token = plugin.getConfig().getString("bot.token");
		String prefix = plugin.getConfig().getString("bot.prefix");
		DiscordApi api = new DiscordApiBuilder().setToken(token).setAllNonPrivilegedIntents().login().join();
		api.addMessageCreateListener(new RenderCommand(plugin, prefix));
		
		//Long cacheRate = plugin.getConfig().getLong("cacheinterval", 12000);
		//Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, ()->{}, cacheRate, cacheRate);
	}
}
