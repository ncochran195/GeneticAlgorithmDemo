package com.entropicbox.geneticfish.game;

import java.util.ArrayList;
import java.util.List;

import com.entropicbox.geneticfish.graphics.GameGraphics;
import com.entropicbox.geneticfish.member.Member;
import com.entropicbox.geneticfish.member.MemberFactory;
import com.entropicbox.geneticfish.member.MemberPool;
import com.entropicbox.geneticfish.world.World;

public class Game {
		
	private World world;
	private MemberPool memberPool;
	private boolean running = false;

	private int stepsPerGeneration;
	private float generationWeight;
	
	private float mutationRate;
	private float mutationAmount;
	
	transient GameGraphics gameGraphics;

	
	public Game(int stepsPerGeneration, float generationWeight, float mutationRate, float mutationAmount) {
		this.stepsPerGeneration = stepsPerGeneration;
		this.generationWeight = generationWeight;
		this.mutationRate = mutationRate;
		this.mutationAmount = mutationAmount;
	}
	
	private static boolean slow = true;
	public void run() {
		this.running = true;

		int generationCt = 0;
				
		while(this.running) {

			for (int stepct = 0; stepct < this.stepsPerGeneration; stepct++) {
				update();
				render();
				if (slow) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			newGeneration();
			generationCt++;
			System.out.println("Fittest for generation " + generationCt + ": " + memberPool.getMember(0));
			System.out.println("Fitness: " + memberPool.getMember(0).getFitnessInWorld(world));
			
			world.shuffleGoal();
		}
	}
	
	public void newGeneration() {
		//	Get fittest 50%
		memberPool.sortMemberPoolByFitnessInWorld(world);
		List<Member> fittest = new ArrayList<Member>();
		for (int i = 0; i < memberPool.getNumMembers()/2; i++) {
			fittest.add(memberPool.getMember(i));
		}
		
		//	Pair fittest husbands and Wives
		List<Member> newChildren = new ArrayList<Member>();
		for (int i = 0; i < fittest.size(); i++) {
			if (i % 2 == 0) {
				//	Mix the members to generate new generation
				Member husbandsChild = MemberFactory.GenerateChild(fittest.get(i), fittest.get(i+1), generationWeight, world);
				Member wifesChild = MemberFactory.GenerateChild(fittest.get(i+1), fittest.get(i), generationWeight, world);
				newChildren.add(husbandsChild);
				newChildren.add(wifesChild);
			}
		}
		
		//	replace bottom 50%
		for (int i = memberPool.getNumMembers()/2; i < memberPool.getNumMembers(); i++) {
			Member newMember = newChildren.get(i-memberPool.getNumMembers()/2);
			newMember.mutate(mutationRate, mutationAmount);
			memberPool.setMember(newMember, i);
		}
	}

	public void stopAfterGeneration() {
		this.running = false;
	}
	
	public void update() {
		for (int i = 0; i < memberPool.getNumMembers(); i++) {
			memberPool.getMember(i).update(world);
		}
	}
	
	public void render() {
		gameGraphics.render();
	}
	
	public void initWithWorldAndMemberPool(World world, MemberPool memberPool) {
		this.world = world;
		this.memberPool = memberPool;
		this.gameGraphics = new GameGraphics(this);
	}

	public World getWorld() {
		return this.world;
	}
	
	public MemberPool getMemberPool() {
		return this.memberPool;
	}
	
	public void toggleSpeed() {
		slow = !slow;
	}
}
