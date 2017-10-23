package com.entropicbox.geneticfish.world;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorldTest {

	@Test
	public void testWorldCreate() {
		World simpleWorld = WorldTestUtils.generateSimpleWorld();
		assertTrue(simpleWorld != null);
	}
	
	@Test
	public void testWorldSize() {
		World simpleWorld = WorldTestUtils.generateSimpleWorld();
		assertTrue(simpleWorld.getWidth() == 200 && simpleWorld.getHeight() == 100);
	}

	@Test
	public void testWorlGoal() {
		World simpleWorld = WorldTestUtils.generateSimpleWorld();
		assertTrue(simpleWorld.getGoal().getX() == 100 && simpleWorld.getGoal().getY() == 50);
	}

}
