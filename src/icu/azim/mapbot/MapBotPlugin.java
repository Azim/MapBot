package icu.azim.mapbot;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

//import net.minecraft.server.v1_16_R3.Chunk;

import icu.azim.mapbot.logic.DirtyListener;
import icu.azim.mapbot.logic.Renderer;
import icu.azim.mapbot.util.Config;
import net.byteflux.libby.BukkitLibraryManager;

public class MapBotPlugin extends JavaPlugin {
	private Renderer renderer;
	private Config cfg;
	
	@Override
	public void onEnable() {
		super.onEnable();
		BukkitLibraryManager manager = new BukkitLibraryManager(this);
    	manager.addMavenCentral();
    	manager.addRepository("https://papermc.io/repo/repository/maven-public");
    	manager.fromGeneratedResource(this.getResource("AzimDP.json")).forEach(library->{
    		try {
            	manager.loadLibrary(library);
    		}catch(RuntimeException e) {
    			getLogger().info("Skipping download of \""+library+"\", it either doesnt exist or has no .jar file");
    		}
    	});
    	this.saveDefaultConfig();
    	cfg = new Config(this);
    	getServer().getPluginManager().registerEvents(new DirtyListener(this), this);
    	renderer = new Renderer(cfg);
    	new JavacordBot(this);
    	
		World world = Bukkit.getWorld(cfg.getDefaultWorld());
		if(world==null) {
			getLogger().warning("Default world, specified in config, doesnt exist! Using first world we could find instead.");
		}
    	Bukkit.getScheduler().runTaskTimerAsynchronously(this, ()->{
    		if(world==null) {
        		renderer.fullRender(Bukkit.getWorlds().get(0), cfg.getMaxSizeX(), cfg.getMaxSizeZ(), cfg.getThreads());
    		}else {
        		renderer.fullRender(world, cfg.getMaxSizeX(), cfg.getMaxSizeZ(), cfg.getThreads());
    		}
    	}, cfg.getRefreshRate(), cfg.getRefreshRate());
	}
	public Renderer getRenderer() {
		return renderer;
	}
	public Config getMyConfig() {
		return cfg;
	}
}
