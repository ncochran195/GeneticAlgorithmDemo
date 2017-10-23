package com.entropicbox.geneticfish.world;

public class Goal {
	private int x;
	private int y;
	
	public Goal() {
	}
	
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}
