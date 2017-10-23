package com.entropicbox.geneticfish.world;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorldFactoryTest {
	
	@Test
	public void testRandomlyGeneratedWorld() {
		World randomWorld = WorldFactory.buildRandomWorldWithSize(200, 100);
		
		assertTrue(randomWorld != null);
		
		assertTrue(randomWorld.getWidth() == 200 && randomWorld.getHeight() == 100);
		
		assertTrue(0 <= randomWorld.getGoal().getX() && randomWorld.getGoal().getX() <= randomWorld.getWidth());
		assertTrue(0 <= randomWorld.getGoal().getY() && randomWorld.getGoal().getY() <= randomWorld.getHeight());
	}
}
