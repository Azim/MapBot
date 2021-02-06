package icu.azim.mapbot.util;

import java.util.Objects;

public class Vector2i {
	private int x,y;
	public Vector2i(int x, int y) {
		setX(x);
		setY(y);
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Vector2i) {
			Vector2i v = (Vector2i) obj;
			return(v.getX()==this.getX() && v.getY()==this.getY());
		}
		return false;
	}
	
	@Override
	public String toString() {
		return x+":"+y;
	}
	
}
