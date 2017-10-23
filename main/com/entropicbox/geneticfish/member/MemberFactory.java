package com.entropicbox.geneticfish.member;

import java.util.Random;

import com.entropicbox.geneticfish.neuralnetwork.NeuralNetwork;
import com.entropicbox.geneticfish.neuralnetwork.NeuralNetworkFactory;
import com.entropicbox.geneticfish.world.World;

public class MemberFactory {

	public static Member buildRandomMemberInWorld(World world, float memberSpeed) {
		Random r = new Random();
		Member member = new Member(NeuralNetworkFactory.buildRandomSingleLayerPerceptron(2, 2), memberSpeed);
		member.moveTo(Math.round(r.nextFloat()*world.getWidth()), Math.round(r.nextFloat()*world.getHeight()));
		return member;
	}
	
	public static Member GenerateChild(Member husband, Member wife, float weight, World world) {
		//	Weighted average the neural nets
		NeuralNetwork childNet = NeuralNetworkFactory.weightedAverageSingleLayerPerceptrons(husband.getNeuralNetwork(), wife.getNeuralNetwork(), weight);
		
		Member child = new Member(childNet, husband.getSpeed());
		
		Random r = new Random();
		child.moveTo(Math.round(r.nextFloat()*world.getWidth()), Math.round(r.nextFloat()*world.getHeight()));
		//child.moveTo(husband.getX(), husband.getY());
		return child;
	}
}
