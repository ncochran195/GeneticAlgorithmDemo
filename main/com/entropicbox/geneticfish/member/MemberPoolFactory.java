package com.entropicbox.geneticfish.member;

import com.entropicbox.geneticfish.world.World;

public class MemberPoolFactory {
	public static MemberPool buildRandomMemberPoolOfSizeInWorld(int size, World world, float memberSpeed) {
		MemberPool memberPool = new MemberPool(size);
		for (int i = 0; i < memberPool.getNumMembers(); i++) {
			memberPool.setMember(MemberFactory.buildRandomMemberInWorld(world, memberSpeed), i);
		}
		return memberPool;
	}
}
