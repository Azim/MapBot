package icu.azim.mapbot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import icu.azim.mapbot.logic.RenderCommand;

public class JavacordBot {
	
	public JavacordBot(MapBotPlugin plugin) {
		String token = plugin.getConfig().getString("bot.token");
		DiscordApi api = new DiscordApiBuilder().setToken(token).setAllNonPrivilegedIntents().login().join();
		api.addMessageCreateListener(new RenderCommand(plugin));
		if(plugin.getMyConfig().doGenerateInvite()) {
			plugin.getLogger().info("You can invite the bot using following link: "+api.createBotInvite());
		}
	}
}
