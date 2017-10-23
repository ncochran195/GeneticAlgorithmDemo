package com.entropicbox.geneticfish.world;

import java.util.Random;

public class World {

	private int width;
	private int height;
	
	private Goal goal;
	
	public World(int width, int height, Goal goal) {
		this.width = width;
		this.height = height;
		this.goal = goal;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public Goal getGoal() {
		return this.goal;
	}
	
	public void shuffleGoal() {
		Random r = new Random();
		goal.moveTo(Math.round(r.nextFloat()*width), Math.round(r.nextFloat()*height));
	}
}
