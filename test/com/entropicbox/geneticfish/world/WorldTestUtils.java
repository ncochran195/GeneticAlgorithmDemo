package com.entropicbox.geneticfish.world;

public class WorldTestUtils {

	public static World generateSimpleWorld() {
		return new World(200, 100, generateSimpleGoal());
	}
	
	public static Goal generateSimpleGoal() {
		Goal goal = new Goal();
		goal.moveTo(100, 50);
		return goal;
	}
}
