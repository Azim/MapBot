package icu.azim.mapbot;

import org.bukkit.plugin.java.JavaPlugin;

//import net.minecraft.server.v1_16_R3.Chunk;

import icu.azim.mapbot.logic.DirtyListener;
import icu.azim.mapbot.logic.Renderer;
import net.byteflux.libby.BukkitLibraryManager;

public class MapBotPlugin extends JavaPlugin {
	private Renderer renderer = new Renderer();
	
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
    	getServer().getPluginManager().registerEvents(new DirtyListener(this), this);
    	new JavacordBot(this);
	}
	public Renderer getRenderer() {
		return renderer;
	}
}
