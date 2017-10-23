package com.entropicbox.geneticfish.game;

import com.entropicbox.geneticfish.member.MemberPool;
import com.entropicbox.geneticfish.member.MemberPoolFactory;
import com.entropicbox.geneticfish.world.World;
import com.entropicbox.geneticfish.world.WorldFactory;

public class GameFactory {
	private static int WORLD_WIDTH = 500;
	private static int WORLD_HEIGHT = 300;
	private static int MEMBER_POOL_SIZE = 20;
	private static int STEPS_PER_GENERATION = 10;
	private static float GENERATION_WEIGHT = .1f;
	private static float MEMBER_SPEED = 20f;

	private static float MUTATION_RATE = .1f;
	private static float MUTATION_AMOUNT = .1f;
	
	public static Game buildRandomGame() {
		World world = WorldFactory.buildRandomWorldWithSize(WORLD_WIDTH, WORLD_HEIGHT);
		MemberPool memberPool = MemberPoolFactory.buildRandomMemberPoolOfSizeInWorld(MEMBER_POOL_SIZE, world, MEMBER_SPEED);
		Game game = new Game(STEPS_PER_GENERATION, GENERATION_WEIGHT, MUTATION_RATE, MUTATION_AMOUNT);
		game.initWithWorldAndMemberPool(world, memberPool);
		return game;
	}
}
