package icu.azim.mapbot.logic;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.util.logging.ExceptionLogger;

import icu.azim.mapbot.MapBotPlugin;
import icu.azim.mapbot.util.Config;
import icu.azim.mapbot.util.Vector2i;

public class RenderCommand implements MessageCreateListener {

	private MapBotPlugin plugin;
	private PermissionChecker permissions;
	private String prefix;
	private int threads;
	private String defaultWorld;
	private int defaultSizeX, defaultSizeZ, maxSizeX, maxSizeZ;

	public RenderCommand(MapBotPlugin plugin) {
		Config cfg = plugin.getMyConfig();
		this.plugin = plugin;
		this.prefix = cfg.getPrefix();
		//FileConfiguration config = plugin.getConfig();
		threads = cfg.getThreads();
		defaultWorld = cfg.getDefaultWorld();
		defaultSizeX = cfg.getDefaultSizeX();
		defaultSizeZ = cfg.getDefaultSizeZ();
		maxSizeX = cfg.getMaxSizeX();
		maxSizeZ = cfg.getMaxSizeZ();
		if(defaultSizeX > maxSizeX) defaultSizeX = maxSizeX;
		if(defaultSizeZ > maxSizeZ) defaultSizeZ = maxSizeZ;
		permissions = new PermissionChecker(plugin);
	}

	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		if(!event.getMessageAuthor().isUser()) return;
		long authorId = event.getMessageAuthor().getId();
		Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
			String content = event.getMessageContent();
			String prefix;
			if (content.startsWith(this.prefix)) {
				prefix = this.prefix;
			} else if (content.startsWith(event.getApi().getYourself().getMentionTag())) {
				prefix = event.getApi().getYourself().getMentionTag() + " ";
			} else {
				return;
			}
			String command = content.substring(prefix.length());
			String[] parts = command.split(" ");

			int xmin, zmin, xmax, zmax;
			World world = Bukkit.getWorld(defaultWorld);
			if (world == null) {
				plugin.getLogger().warning("Default world, specified in config, doesnt exist! Using first world we could find instead.");
				world = Bukkit.getWorlds().get(0);
			}
			if (parts[0].equalsIgnoreCase("fullrender")) {
				if(!permissions.hasPermissionFull(authorId)) {
					sendNoPerms(event.getChannel());
					return;
				}
				if(parts.length>1) {
					World tmp = Bukkit.getWorld(parts[1]);
					if (tmp != null) world = tmp;
				}

				WorldBorder border = world.getWorldBorder();
				Location center = border.getCenter();
				
				double width = border.getSize() / 2d;
				double height = border.getSize() / 2d;
				if(width>maxSizeX)  width  = maxSizeX;
				if(height>maxSizeZ) height = maxSizeZ;
				
				double bxMin = center.getX() - width;
				double bzMin = center.getZ() - height;
				double bxMax = center.getX() + width;
				double bzMax = center.getZ() + height;

				xmin = (int) Math.floor(bxMin / 16);
				zmin = (int) Math.floor(bzMin / 16);
				xmax = (int) Math.ceil(bxMax / 16);
				zmax = (int) Math.ceil(bzMax / 16);
			} else if (parts[0].equalsIgnoreCase("render")) {
				if(!permissions.hasPermissionLocal(authorId)) {
					sendNoPerms(event.getChannel());
					return;
				}
				double bxMin, bxMax, bzMin, bzMax;
				Vector2i cv;
				switch (parts.length) {
				default:
					event.getChannel().sendMessage("Invalid arguments.").thenAccept(m->{
						sendUsage(event.getChannel());
					}).join();
					return;
				case 1:
					Location center = world.getSpawnLocation();
					bxMin = center.getX() - ((double) defaultSizeX * 16) / 2;
					bzMin = center.getZ() - ((double) defaultSizeZ * 16) / 2;
					bxMax = center.getX() + ((double) defaultSizeX * 16) / 2;
					bzMax = center.getZ() + ((double) defaultSizeZ * 16) / 2;

					xmin = (int) Math.floor(bxMin / 16);
					zmin = (int) Math.floor(bzMin / 16);
					xmax = (int) Math.ceil(bxMax / 16);
					zmax = (int) Math.ceil(bzMax / 16);
					break;
				case 3:
					try {
						cv = new Vector2i(Integer.valueOf(parts[1]), Integer.valueOf(parts[2]));
					} catch (NumberFormatException e) {
						sendInvalidFormat(event.getChannel());
						return;
					}
					xmin = (int) Math.floor(cv.getX() - ((double) defaultSizeX) / 2);
					zmin = (int) Math.floor(cv.getY() - ((double) defaultSizeZ) / 2);
					xmax = (int) Math.ceil(cv.getX() + ((double) defaultSizeX) / 2);
					zmax = (int) Math.ceil(cv.getY() + ((double) defaultSizeZ) / 2);
					break;
				case 4:
					int radius;
					try {
						cv = new Vector2i(Integer.valueOf(parts[1]), Integer.valueOf(parts[2]));
						radius = Integer.valueOf(parts[3]);
					} catch (NumberFormatException e) {
						sendInvalidFormat(event.getChannel());
						return;
					}
					xmin = cv.getX() - radius;
					zmin = cv.getY() - radius;
					xmax = cv.getX() + radius;
					zmax = cv.getY() + radius;
					break;
				case 5:
					int sx, sz;
					try {
						cv = new Vector2i(Integer.valueOf(parts[1]), Integer.valueOf(parts[2]));
						sx = Integer.valueOf(parts[3]);
						sz = Integer.valueOf(parts[3]);
					} catch (NumberFormatException e) {
						sendInvalidFormat(event.getChannel());
						return;
					}
					xmin = cv.getX() - sx / 2;
					zmin = cv.getY() - sz / 2;
					xmax = cv.getX() + sx / 2;
					zmax = cv.getY() + sz / 2;
					break;
				}
			} else if (parts[0].equalsIgnoreCase("help")) {
				sendUsage(event.getChannel());
				return;
			} else {
				event.getChannel().sendMessage("Unknown command").exceptionally(ExceptionLogger.get());
				return;
			}

			try {
				BufferedImage render = plugin.getRenderer().render(world, xmin, xmax, zmin, zmax, threads);
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				ImageIO.write(render, "png", os);
				InputStream is = new ByteArrayInputStream(os.toByteArray());
				event.getChannel().sendMessage(is, "render.png");
			} catch (IOException e) {
				event.getChannel().sendMessage("Exception occured while rendering world. Is the area too big?\n`"+e.getMessage()+"`");
				e.printStackTrace();
			}
		});
	}
	private void sendNoPerms(TextChannel channel) {
		channel.sendMessage("You dont have permission to do that.").exceptionally(ExceptionLogger.get());
	}

	private void sendInvalidFormat(TextChannel channel) {
		channel.sendMessage("Invalid number format! please try again.").exceptionally(ExceptionLogger.get());
	}

	private void sendUsage(TextChannel channel) {
		channel.sendMessage(String.format("Commands: \n`%1$sfullrender [world]` - renders entire map inside of world border\n"
				+ "`%1$srender chunkX chunkZ` - renders area around given chunk coordinate\n"
				+ "`%1$srender chunkX chunkZ radius` - renders radius-sized area around given chunk coordinate\n"
				+ "`%1$srender chunkX chunkZ width height` - renders area around given chunk coordinate with given size\n",
				this.prefix)).exceptionally(ExceptionLogger.get()).join();
	}
}
