package icu.azim.mapbot.util;

import java.util.Objects;

public class Region {
	private Vector2i start, end;

	public Region(Vector2i start, Vector2i end) {
		this.start = start;
		this.end = end;
	}
	
	public Vector2i getStart() {
		return start;
	}

	public Vector2i getEnd() {
		return end;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(start, end);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Region) {
			Region v = (Region) obj;
			return(v.getStart()==this.getStart() && v.getEnd()==this.getEnd());
		}
		return false;
	}
	
	@Override
	public String toString() {
		return start+","+end;
	}
}
