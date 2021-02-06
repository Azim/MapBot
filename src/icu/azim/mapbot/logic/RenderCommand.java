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
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import icu.azim.mapbot.MapBotPlugin;

public class RenderCommand implements MessageCreateListener {

	private MapBotPlugin plugin;
	
	public RenderCommand(MapBotPlugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		if(!(event.getMessage().getMentionedUsers().contains(event.getApi().getYourself()) && event.getMessageContent().contains("render"))) return;
		if(event.getMessageContent().contains("clear")) {
			plugin.cache.clear();
		}
		String content[] = event.getMessageContent().split(" ");
		int threads = Integer.valueOf(content[content.length-1]);
		Bukkit.getScheduler().runTaskAsynchronously(plugin, ()->{
			try {
				World world = Bukkit.getWorlds().get(0);
				WorldBorder border = world.getWorldBorder();
				Location center = border.getCenter();
				double radius = border.getSize() / 2d;
				double bxMin = center.getX() - radius;
				double bxMax = center.getX() + radius;
				double bzMin = center.getZ() - radius;
				double bzMax = center.getZ() + radius;
				
				int xmin = (int)Math.floor(bxMin /16);
				int zmin = (int)Math.floor(bzMin /16);
				int xmax = (int)Math.ceil(bxMax /16);
				int zmax = (int)Math.ceil(bzMax /16);
				System.out.println("xmin "+xmin);
				System.out.println("zmin "+zmin);
				System.out.println("xmax "+xmax);
				System.out.println("zmax "+zmax);
				
				System.out.println("bxMin "+bxMin);
				System.out.println("bzMin "+bzMin);
				System.out.println("bxMax "+bxMax);
				System.out.println("bzMax "+bzMax);
				
				System.out.println("center "+center);
				System.out.println("radius "+radius);
				
				BufferedImage render = plugin.render(world, xmin, xmax, zmin, zmax, threads);
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				ImageIO.write(render, "png", os);
				InputStream is = new ByteArrayInputStream(os.toByteArray());
				event.getChannel().sendMessage(is, "file.png");
			} catch (IOException e) {
				e.printStackTrace();
			} 
		});
	}
}
