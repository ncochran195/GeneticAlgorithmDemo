package com.entropicbox.geneticfish.member;

import com.entropicbox.geneticfish.neuralnetwork.NeuralNetwork;
import com.entropicbox.geneticfish.world.World;

public class Member {
	private static int idCt = 0;
	
	private int id;
	private int x = 0;
	private int y = 0;
	private float speed;
	
	private NeuralNetwork net;
	
	public Member(NeuralNetwork net, float memberSpeed) {
		this.net = net;
		this.speed = memberSpeed;
		this.id = idCt++;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void update(World worldState) {
		//	Calculate deltaX, deltaY
		int deltaX = worldState.getGoal().getX() - this.x;
		int deltaY = worldState.getGoal().getY() - this.y;
		
		//	Calculate dx, dy
		float dx = (float)deltaX / (float)worldState.getWidth();
		float dy = (float)deltaY / (float)worldState.getHeight();
		
		//	Build input vector
		float[] netInput = new float[] { dx, dy };
		
		//	Get the network output
		float[] translationVector = net.predict(netInput);
		
		//	Move by the translation amount
		this.x += Math.round(speed * translationVector[0]);
		this.y += Math.round(speed * translationVector[1]);
	}
	
	public double getFitnessInWorld(World worldState) {
		//	Calculate deltaX, deltaY
		int deltaX = worldState.getGoal().getX() - this.x;
		int deltaY = worldState.getGoal().getY() - this.y;
		
		//	Calculate dx, dy
		float dx = (float)deltaX / (float)worldState.getWidth();
		float dy = (float)deltaY / (float)worldState.getHeight();

		//	Calculate euclidian distance based on dx, dy, sqrt of a^2 + b^2
		return Math.sqrt( Math.pow(dx, 2) + Math.pow(dy, 2) );
	}
	
	public int compareToInWorld(Member other, World worldState) {
		if (this.getFitnessInWorld(worldState) < other.getFitnessInWorld(worldState))
			return 1;
		else if (this.getFitnessInWorld(worldState) > other.getFitnessInWorld(worldState))
			return -1;
		else
			return 0;
	}
	
	public boolean equals(Member other) {
		return this.getId() == other.getId();
	}
	
	public NeuralNetwork getNeuralNetwork() {
		return this.net;
	}
	
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", x=" + x + ", y=" + y + ", speed="
				+ speed + ", net=" + net + "]";
	}

	public float getSpeed() {
		return this.speed;
	}

	public void mutate(float mutationRate, float mutationAmount) {
		net.mutate(mutationRate, mutationAmount);
	}
}
