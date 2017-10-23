package com.entropicbox.geneticfish.member;

import static org.junit.Assert.*;

import org.junit.Test;

import com.entropicbox.geneticfish.world.World;
import com.entropicbox.geneticfish.world.WorldTestUtils;

public class MemberPoolTest {
	
	@Test
	public void testMemberPoolCreation() {
		MemberPool simplePool = MemberTestUtils.createSimpleMemberPool();
		assertTrue(simplePool != null);
		for (int i = 0; i < simplePool.getNumMembers(); i++) {
			assertTrue(simplePool.getMember(i) != null);
		}
	}
	
	@Test
	public void testMemberPoolSize() {
		MemberPool simplePool = MemberTestUtils.createSimpleMemberPool();
		assertTrue(simplePool.getNumMembers() == 5);
	}
	
	@Test
	public void testMemberFitnessSort() {
		World world = WorldTestUtils.generateSimpleWorld();
		
		Member lessFitMember = MemberTestUtils.createSimpleMember();	
		lessFitMember.moveTo(10, 10);

		Member moreFitMember = MemberTestUtils.createSimpleMember();
		moreFitMember.moveTo(20, 20);

		Member mostFitMember = MemberTestUtils.createSimpleMember();
		mostFitMember.moveTo(30, 30);

		MemberPool pool = new MemberPool(3);
		pool.setMember(lessFitMember, 0);
		pool.setMember(mostFitMember, 1);
		pool.setMember(moreFitMember, 2);
		
		pool.sortMemberPoolByFitnessInWorld(world);
		
		//	Most fit will be first, least fit will be last...
		assertTrue(mostFitMember.equals(pool.getMember(0)));
		assertTrue(moreFitMember.equals(pool.getMember(1)));
		assertTrue(lessFitMember.equals(pool.getMember(2)));
	}
}
