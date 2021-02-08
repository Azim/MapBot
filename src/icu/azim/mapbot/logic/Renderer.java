package icu.azim.mapbot.logic;

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

import icu.azim.mapbot.util.CacheInfo;
import icu.azim.mapbot.util.ColorUtil;
import icu.azim.mapbot.util.Vector2i;

public class Renderer {
	private ExecutorService executor;
	public ConcurrentHashMap<Vector2i, BufferedImage> chunkCache = new ConcurrentHashMap<>();
	public ConcurrentHashMap<CacheInfo, BufferedImage> fullCache = new ConcurrentHashMap<>(); //TODO better system for caching i really need to sleep now
	//public BufferedImage cachedImage;

	public BufferedImage render(World world, int xmin, int xmax, int zmin, int zmax, int threads) {
		executor = Executors.newFixedThreadPool(threads);
		//executor = Executors.new
		long time = System.currentTimeMillis();
		BufferedImage image = null;
		int width = Math.abs(xmax-xmin)*16;
		int height = Math.abs(zmax-zmin)*16;
		boolean clear = true; //TODO caching 
		CacheInfo current = new CacheInfo(new Vector2i(xmin, zmin), new Vector2i(xmax, zmax));
		
		/*
		if(cachedImage==null) {
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			clear = true;
		}else {
			if(cachedImage.getWidth()==width && cachedImage.getHeight()==height) {
				image = copyImage(cachedImage);
				clear = false;
			}else {
				image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				clear = true;
			}
		}*/
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);//TODO caching
		 
		Graphics g = image.getGraphics();
		if(clear) {
			g.setColor(Color.RED);
			g.fillRect(0, 0, image.getWidth(), image.getHeight());
		}
		List<CompletableFuture<Void>> futures = new ArrayList<>();
		
		HashMap<Vector2i, BufferedImage> newCache = new HashMap<>(this.chunkCache);
		
		
		
		for(int cx = xmin; cx < xmax; cx++) {
			for(int cz = zmin; cz < zmax; cz++) {
				int lcx = cx;
				int lcz = cz;
				CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
					Chunk c = world.getChunkAtAsync(lcx, lcz, false).join();
					int x = (lcx-xmin)*16;
					int y = (lcz-zmin)*16;
					if(c==null) {
						drawEmptyChunk(x, y, g);
						return;
					}
					Vector2i chunkVector = new Vector2i(lcx, lcz);
					if(this.chunkCache.containsKey(chunkVector)) {
						if(clear) drawChunk(x, y, g, this.chunkCache.get(chunkVector));
						return;
					}
					BufferedImage piece = generateChunkMap(world, c, chunkVector);
					newCache.put(chunkVector, piece);
					drawChunk(x, y, g, piece);
				}, executor).exceptionally(e->{
					e.printStackTrace(); 
					return null;
				});
				futures.add(future);
			}
		}
		CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).thenRunAsync(()-> {
			for(Vector2i key : newCache.keySet()) {
				this.chunkCache.put(key, newCache.get(key));
			}
		}).join();
		//cachedImage = image; //TODO caching
		System.out.println("Rendered full world in "+(System.currentTimeMillis()-time)+" ms using "+threads+" threads");
		return image;
	}
	
	public static synchronized void drawChunk(int x, int y, Graphics g, BufferedImage chunk) {
		g.drawImage(chunk, x, y, null);
	}
	public static synchronized void drawEmptyChunk(int x, int y, Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 16, 16);
	}
	
	public static BufferedImage generateChunkMap(World world, Chunk c, Vector2i chunkVector) {
		BufferedImage piece = new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB);
		int cx = chunkVector.getX();
		int cz = chunkVector.getY();
		
		ChunkSnapshot snapshot = c.getChunkSnapshot(true,false,false);
		for(int x = 0; x < 16; x++) {
			for(int z = 0; z < 16; z++) {
				int y = getHighestBlock(snapshot, x, z);
				int py = 0;
				if(z==0) {
					Chunk pc = world.getChunkAtAsync(cx, cz-1, false).join();
					if(pc!=null) {;
						ChunkSnapshot ps = pc.getChunkSnapshot(true,false,false);
						py = getHighestBlock(ps, x, 15);
					}else {
						py = y;
					}
				}else {
					py = getHighestBlock(snapshot, x, z-1);
				}
				int colorOffset = 1;
				if(y>py) {
					colorOffset = 2;
				}else if(y<py) {
					colorOffset = 0;
				}
				
				if(snapshot.getBlockType(x, y, z)==Material.WATER||snapshot.getBlockType(x, y, z)==Material.LAVA) {
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
		int y = snapshot.getHighestBlockYAt(x, z);
		while((ColorUtil.getColorCode(snapshot.getBlockType(x, y, z))==0) && y>0) {
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
		return w;
	}
	
	public static BufferedImage copyImage(BufferedImage source){
	    BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
	    Graphics g = b.getGraphics();
	    g.drawImage(source, 0, 0, null);
	    g.dispose();
	    return b;
	}

	
	
	@Deprecated
	@SuppressWarnings("unused")
	private static int getHighestBlock(World world, int x, int z) {
		int y = world.getHighestBlockYAt(x, z);//this one is the issue
		while((ColorUtil.getColorCode(world.getBlockAt(x, y, z).getBlockData().getMaterial())==0) && y>0) {
			y--;
		}
		return y;
	}
	@Deprecated
	@SuppressWarnings("unused")
	private static int getUnderwaterBlock(World world, int y, int x, int z) {
		int w = 0;
		while(world.getBlockAt(x, y--, z).isLiquid()&&y>0) {
			w++;
		}
		return w;
	}
}
