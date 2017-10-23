package com.entropicbox.geneticfish.member;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.entropicbox.geneticfish.world.World;
import com.entropicbox.geneticfish.world.WorldTestUtils;

public class MemberFactoryTest {
	
	@Test
	public void testRandomMemberCreation() {
		World world = WorldTestUtils.generateSimpleWorld();
		Member member = MemberFactory.buildRandomMemberInWorld(world, 10.0f);
		assertTrue(member != null); 
	}
	
	@Test
	public void testMemberLocation() {
		World world = WorldTestUtils.generateSimpleWorld();
		Member member = MemberFactory.buildRandomMemberInWorld(world, 10.0f);
		assertTrue(	member.getX() >= 0 && member.getX() <= world.getWidth() &&
					member.getY() >= 0 && member.getY() <= world.getHeight()); 
	}
}
