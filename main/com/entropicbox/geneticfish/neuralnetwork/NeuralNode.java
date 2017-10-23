package com.entropicbox.geneticfish.neuralnetwork;


public abstract class NeuralNode {
	private static int idCt = 0;

	protected float output = 0.0f;

	public abstract float calculateOutput();
	
	private int id;

	protected NeuralNode() {
		this.id = idCt++;
	}
	
	public int id() {
		return this.id;
	}
	
	
	@Override
	public String toString() {
		return "NeuralNode [output=" + output + ", id=" + id + "]";
	}

	public float getOutput() {
		return output;
	}
	
	public void setOutput(float output) {
		this.output = output;
	}
	
	protected float sigmond(float in) {
		return (float)(1.0 / (1.0 + Math.pow(Math.E, -in)));
	}
}
