package com.entropicbox.geneticfish.member;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.entropicbox.geneticfish.world.World;
import com.entropicbox.geneticfish.world.WorldTestUtils;

public class MemberTest {

	@Test
	public void testMemberCreate() {
		Member member = MemberTestUtils.createSimpleMember();
		assertTrue(member != null);
	}
	
	@Test
	public void testMemberLocation() {
		Member member = MemberTestUtils.createSimpleMember();
		assertTrue(member.getX() == 10 && member.getY() == 10);
	}
	
	@Test 
	public void testMemberUpdate() {
		World world = WorldTestUtils.generateSimpleWorld();
		Member member = MemberTestUtils.createSimpleMember();
		member.update(world);
		assertTrue(member.getX() == 5 && member.getY() == 15);
	}
	
	@Test
	public void testMemberFitness() {
		World world = WorldTestUtils.generateSimpleWorld();
		Member member = MemberTestUtils.createSimpleMember();
		double fitness = member.getFitnessInWorld(world);
		//	Sqrt(dx^2 + dy^2)
		assertTrue(fitness == 0.6020797239897185);
	}
	
	@Test
	public void testMemberFitnessComparison() {
		World world = WorldTestUtils.generateSimpleWorld();
		
		Member lessFitMember = MemberTestUtils.createSimpleMember();	
		Member anotherLessFitMember = MemberTestUtils.createSimpleMember();	
		
		Member moreFitMember = MemberTestUtils.createSimpleMember();
		moreFitMember.moveTo(20, 20);
		
		int comparison = lessFitMember.compareToInWorld(moreFitMember, world);
		assertTrue(comparison == -1);
		
		comparison = moreFitMember.compareToInWorld(lessFitMember, world);
		assertTrue(comparison == 1);
		
		comparison = lessFitMember.compareToInWorld(anotherLessFitMember, world);
		assertTrue(comparison == 0);
	}
}
