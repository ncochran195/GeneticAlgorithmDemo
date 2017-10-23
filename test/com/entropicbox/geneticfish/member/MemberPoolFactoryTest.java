package com.entropicbox.geneticfish.member;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.entropicbox.geneticfish.world.World;
import com.entropicbox.geneticfish.world.WorldTestUtils;

public class MemberPoolFactoryTest {
	
	@Test
	public void testMemberPoolCreation() {
		World world = WorldTestUtils.generateSimpleWorld();
		MemberPool randomPool = MemberPoolFactory.buildRandomMemberPoolOfSizeInWorld(10, world, 10.0f);
		assertTrue(randomPool != null);
		for (int i = 0; i < randomPool.getNumMembers(); i++) {
			assertTrue(randomPool.getMember(i) != null);
		}
	}
	
	@Test
	public void testMemberPoolSize() {
		World world = WorldTestUtils.generateSimpleWorld();
		MemberPool randomPool = MemberPoolFactory.buildRandomMemberPoolOfSizeInWorld(10, world, 10.0f);
		assertTrue(randomPool.getNumMembers() == 10);
	}

}
