package com.entropicbox.geneticfish.neuralnetwork;

import java.util.Random;


public class OutputNode extends NeuralNode {
	private float bias;
	//	Parallel arrays
	private NeuralNode[] children;
	private float[] weights;
	
	//	For hidden layers/output layer
	public OutputNode(NeuralNode[] children, float[] weights, float bias) {
		super();
		
		this.children = children;
		this.weights = weights;
		this.bias = bias;
	}
	
	public float calculateOutput() {
		this.output = 0.0f;
		for (int i = 0; i < this.children.length; i++) {
			output += weights[i]*children[i].getOutput();
		}
		this.output -= bias;
		//return sigmond(this.output);
		return this.output;
	}
	
		
	public NeuralNode[] getChildren() {
		return children;
	}
	public void setChildren(NeuralNode[] children) {
		this.children = children;
	}
	public float getBias() {
		return bias;
	}
	public void setBias(float bias) {
		this.bias = bias;
	}
	public float[] getWeights() {
		return weights;
	}
	public void setWeights(float[] weights) {
		this.weights = weights;
	}

	public void mutate(float mutationRate, float mutationAmount) {
		Random r = new Random();
		//	See if bias needs to change
		if (r.nextFloat() > mutationRate) {
			//	If so, determine if positive
			if (r.nextBoolean()) {
				this.bias += mutationAmount;
			}
			else {
				this.bias -= mutationAmount;
			}
		}
		
		//	Check each weight
		for (int i = 0; i < this.weights.length; i++) {
			//	See if it needs to change
			if (r.nextFloat() > mutationRate) {
				//	If so, determine if positive
				if (r.nextBoolean()) {
					this.weights[i] += mutationAmount;
				}
				else {
					this.weights[i] -= mutationAmount;
				}
			}

		}
	}
}
