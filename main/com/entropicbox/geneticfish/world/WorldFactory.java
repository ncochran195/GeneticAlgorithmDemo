package com.entropicbox.geneticfish.world;

import java.util.Random;

public class WorldFactory {

	public static World buildRandomWorldWithSize(int width, int height) {
		Random r = new Random();
		Goal goal = new Goal();
		goal.moveTo(Math.round(r.nextFloat()*width), Math.round(r.nextFloat()*height));
		return new World(width, height, goal);
	}
}
