package com.entropicbox.geneticfish.game;

import com.entropicbox.geneticfish.member.MemberPool;
import com.entropicbox.geneticfish.member.MemberTestUtils;
import com.entropicbox.geneticfish.world.World;
import com.entropicbox.geneticfish.world.WorldTestUtils;

public class GameTestUtils {

	public static Game createSimpleGame() {
		World world = WorldTestUtils.generateSimpleWorld();
		MemberPool memberPool = MemberTestUtils.createSimpleMemberPool();
		
		Game game = new Game(10, .1f, .1f, .1f);
		game.initWithWorldAndMemberPool(world, memberPool);
		
		return game;
	}
}
