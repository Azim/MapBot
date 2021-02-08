package icu.azim.mapbot.util;

import java.util.Objects;

public class CacheInfo {
	private Vector2i start, end;
	private long creationDate; //explicitly ignored in equals and hashcode checks
	
	public CacheInfo(Vector2i start, Vector2i end) {
		this.start = start;
		this.end = end;
		creationDate = System.currentTimeMillis();
	}
	
	public long getCreationDate() {
		return creationDate;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(start, end);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) return true;
		if(obj instanceof CacheInfo) {
			CacheInfo v = (CacheInfo) obj;
			return(v.start==this.start && v.end==this.end);
		}
		return false;
	}
	
}
