package com.entropicbox.geneticfish.member;

import com.entropicbox.geneticfish.neuralnetwork.NeuralNetworkTestUtils;

public class MemberTestUtils {
	public static Member createSimpleMember() {
		Member member = new Member(NeuralNetworkTestUtils.generateSimpleSingleLayerPerceptron(), 10.0f);
		member.moveTo(10, 10);
		return member;
	}
	
	public static MemberPool createSimpleMemberPool() {
		MemberPool memberPool = new MemberPool(5);
		for (int i = 0; i < memberPool.getNumMembers(); i++) {
			memberPool.setMember(createSimpleMember(), i);
		}
		return memberPool;
	}
}
