package icu.azim.mapbot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import icu.azim.mapbot.logic.DirtyListener;
import icu.azim.mapbot.util.ColorUtil;
import icu.azim.mapbot.util.Vector2i;
import net.byteflux.libby.BukkitLibraryManager;

public class MapBotPlugin extends JavaPlugin {
	
	public int threadCount = 4;
	private ExecutorService executor;
	public ConcurrentHashMap<Vector2i, BufferedImage> cache = new ConcurrentHashMap<>();
	public BufferedImage cachedImage;
	public static long printcount = 1000;
	
	@Override
	public void onEnable() {
		super.onEnable();
		BukkitLibraryManager manager = new BukkitLibraryManager(this);
    	manager.addMavenCentral();
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
	/**
	 * creates world map
	 * @param world where
	 * @param xmin 
	 * @param xmax
	 * @param zmin
	 * @param zmax
	 * @param threads amount of threads to use
	 * @return rendered map
	 */
	public BufferedImage render(World world, int xmin, int xmax, int zmin, int zmax, int threads) {
		executor = Executors.newFixedThreadPool(threads);
		long time = System.currentTimeMillis();
		BufferedImage image = null;
		int width = Math.abs(xmax-xmin)*16;
		int height = Math.abs(zmax-zmin)*16;
		boolean clear = false;
		if(cachedImage==null) {
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			clear = true;
		}else {
			if(cachedImage.getWidth()==width && cachedImage.getHeight()==height) {
				image = copyImage(cachedImage);
			}else {
				image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				clear = true;
			}
		}
		 
		Graphics g = image.getGraphics();
		if(clear) {
			g.setColor(Color.RED);
			g.fillRect(0, 0, image.getWidth(), image.getHeight());
		}
		List<CompletableFuture<Void>> futures = new ArrayList<>();
		
		HashMap<Vector2i, BufferedImage> newCache = new HashMap<>(this.cache);
		
		for(int cx = xmin; cx < xmax; cx++) {
			for(int cz = zmin; cz < zmax; cz++) {
				if(!world.isChunkGenerated(cx, cz)) {
					g.setColor(Color.BLACK);
					g.fillRect((cx-xmin)*16, (cz-zmin)*16, 16, 16);
					continue;
				}
				Vector2i chunkVector = new Vector2i(cx, cz);
				if(this.cache.containsKey(chunkVector)) {
					if(clear) g.drawImage(this.cache.get(chunkVector), (cx-xmin)*16, (cz-zmin)*16, null); //only redraw when we recreate the entire thing
					System.out.println("Skipping "+chunkVector);
					continue;
				}
				
				int x = (cx-xmin)*16;
				int y = (cz-zmin)*16;
				//CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
					BufferedImage piece = generateChunkMap(world, chunkVector);
					newCache.put(chunkVector, piece);
					drawChunk(x, y, g, piece);
				//}, executor).exceptionally(e->{
					//e.printStackTrace(); 
					//return null;
				//});
				//futures.add(future);
			}
		}
		CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).thenRunAsync(()-> {
			for(Vector2i key : newCache.keySet()) {
				this.cache.put(key, newCache.get(key));
			}
		}).join();
		cachedImage = image;
		System.out.println("Rendered full world in "+(System.currentTimeMillis()-time)+" ms using "+threads+" threads");
		return image;
	}
	
	public static synchronized void drawChunk(int x, int y, Graphics g, BufferedImage chunk) {
		g.drawImage(chunk, x, y, null);
	}
	
	public static BufferedImage generateChunkMap(World world, Vector2i chunkVector) {
		BufferedImage piece = new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB);
		int cx = chunkVector.getX();
		int cz = chunkVector.getY();
		System.out.println("before check "+chunkVector);
		if(!world.isChunkGenerated(cx, cz)) return piece;
		System.out.println("before chunk");
		Chunk chunk = world.getChunkAt(cx, cz);
		System.out.println("before snapshot");
		ChunkSnapshot snapshot = chunk.getChunkSnapshot(true,false,false);
		for(int x = 0; x < 16; x++) {
			System.out.println(" each column");
			for(int z = 0; z < 16; z++) {
				System.out.println("  each row");
				//int y = getHighestBlock(world, cx*16+x, cz*16+z);
				int y = getHighestBlock(snapshot, x, z);
				int py = 0;
				if(z==0) {
					if(world.isChunkGenerated(cx, cz-1)) {
						Chunk pc = world.getChunkAt(cx, cz-1);
						ChunkSnapshot ps = pc.getChunkSnapshot(true,false,false);
						
						//py = getHighestBlock(world, cx*16+x, cz*16-1);
						py = getHighestBlock(ps, x, 15);
					}else {
						py = y;
					}
				}else {
					//py = getHighestBlock(world, cx*16+x, cz*16+z-1);
					py = getHighestBlock(snapshot, x, z-1);
				}
				int colorOffset = 1;
				if(y>py) {
					colorOffset = 2;
				}else if(y<py) {
					colorOffset = 0;
				}
				
				if(snapshot.getBlockType(x, y, z)==Material.WATER||snapshot.getBlockType(x, y, z)==Material.LAVA) {
				//if(world.getBlockAt(cx*16+x, y, cz*16+z).isLiquid()) {
					//int by = getUnderwaterBlock(world, y, cx*16+x, cz*16+z);
					int by = getUnderwaterBlock(snapshot, y, x, z);
					double f = by*0.1D + (x+z & 1)*0.2D; //magic numbers from mc source
					if(f<0.5D) {
						colorOffset = 2;
					}else if(f>0.9D) {
						colorOffset = 0;
					}else {
						colorOffset = 1;
					}
				}
				
				if(y>0) {
					piece.setRGB(x, z, ColorUtil.getColor(
						ColorUtil.getColorCode( 
								snapshot.getBlockType(x, y, z)
								//world.getBlockAt(cx*16+x, y, cz*16+z).getBlockData().getMaterial()
								), 
						colorOffset).getRGB());
				}else {
					piece.setRGB(x, z, Color.BLACK.getRGB());
				}
			}
		}
		return piece;
	}

	private static int getHighestBlock(ChunkSnapshot snapshot, int x, int z) {
		System.out.println("   sbefore getHighestBlockYAt");
		int y = snapshot.getHighestBlockYAt(x, z);//this one is the issue
		System.out.println("   before loop");
		while((ColorUtil.getColorCode(snapshot.getBlockType(x, y, z))==0) && y>0) {
			y--;
		}
		return y;
	}
	
	private static int getHighestBlock(World world, int x, int z) {
		int y = world.getHighestBlockYAt(x, z);//this one is the issue
		while((ColorUtil.getColorCode(world.getBlockAt(x, y, z).getBlockData().getMaterial())==0) && y>0) {
			y--;
		}
		return y;
	}

	private static int getUnderwaterBlock(ChunkSnapshot snapshot, int y, int x, int z) {
		int w = -1;
		Material m;
		do {
			m = snapshot.getBlockType(x, y--, z);
			w++;
		}while(y>0&& m!=Material.LAVA && m!=Material.WATER);
		
		/*
		while(world.getBlockAt(x, y--, z).isLiquid()&&y>0) {
			w++;
		}*/
		return w;
	}
	
	private static int getUnderwaterBlock(World world, int y, int x, int z) {
		int w = 0;
		while(world.getBlockAt(x, y--, z).isLiquid()&&y>0) {
			w++;
		}
		return w;
	}
	
	public static BufferedImage copyImage(BufferedImage source){
	    BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
	    Graphics g = b.getGraphics();
	    g.drawImage(source, 0, 0, null);
	    g.dispose();
	    return b;
	}
}
