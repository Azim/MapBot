package icu.azim.mapbot.util;

import java.awt.image.BufferedImage;

public class CacheInfo {
	private Region region; //redundant?
	private long creationDate; //explicitly ignored in equals and hashcode checks
	private BufferedImage cacheData;
	
	public CacheInfo(Region region, BufferedImage data) {
		this.region = region;
		creationDate = System.currentTimeMillis();
		cacheData = data;
	}
	public CacheInfo(Vector2i start, Vector2i end, BufferedImage data) {
		this.region = new Region(start, end);
		creationDate = System.currentTimeMillis();
		cacheData = data;
	}
	
	public long getCreationDate() {
		return creationDate;
	}
	
	public BufferedImage getData() {
		return cacheData;
	}
	
	public Region getRegion() {
		return region;
	}
}
