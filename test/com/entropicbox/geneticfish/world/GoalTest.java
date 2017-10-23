package com.entropicbox.geneticfish.world;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GoalTest {

	@Test
	public void testGoalCreate() {
		Goal simpleGoal = WorldTestUtils.generateSimpleGoal();
		assertTrue(simpleGoal != null);
	}
	
	@Test
	public void testGoalLocation() {
		Goal simpleGoal = WorldTestUtils.generateSimpleGoal();
		assertTrue(simpleGoal.getX() == 100 && simpleGoal.getY() == 50);
	}

}
