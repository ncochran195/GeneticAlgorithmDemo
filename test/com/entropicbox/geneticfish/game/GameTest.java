package com.entropicbox.geneticfish.game;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameTest {
	
	@Test
	public void testRandomGameInitialization() {
		Game game = GameFactory.buildRandomGame();
		
		assertTrue(game.getWorld() != null);
		assertTrue(game.getWorld().getGoal() != null);
		assertTrue(game.getMemberPool() != null);
		for (int i = 0; i < game.getMemberPool().getNumMembers(); i++) {
			assertTrue(game.getMemberPool().getMember(i) != null);
		}
	}
	
	@Test 
	public void testGameUpdate() {
		Game game = GameTestUtils.createSimpleGame();
		
		game.update();
		
		//	After one update, all members should be at (5, 15)
		for (int i = 0; i < game.getMemberPool().getNumMembers(); i++) {
			assertTrue(game.getMemberPool().getMember(i).getX() == 5 && game.getMemberPool().getMember(i).getY() == 15);
		}
	}
	
	//	This is handles by the actual game running...
	/*@Test
	public void testGameRunStop() {
		final Game game = GameTestUtils.createSimpleGame();
		
		new Thread()
		{
		    public void run() {
		        game.run();
		    }
		}.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		game.stopAfterGeneration();
		
		assertTrue(game.getWorld() != null);
		assertTrue(game.getWorld().getGoal() != null);
		assertTrue(game.getMemberPool() != null);
		for (int i = 0; i < game.getMemberPool().getNumMembers(); i++) {
			assertTrue(game.getMemberPool().getMember(i) != null);
		}
	}*/
}
