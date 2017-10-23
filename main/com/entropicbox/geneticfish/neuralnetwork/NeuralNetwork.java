package com.entropicbox.geneticfish.neuralnetwork;

public abstract class NeuralNetwork {
	public static int idCt = 0;
	
	protected InputNode[] inputs;
	protected OutputNode[] outputs;

	protected int id;
	public abstract float[] predict(float[] inputValues);
		
	public int getId() {
		return id;
	}
	
	protected NeuralNetwork() {
		this.id = idCt++;
	}
	
	public abstract NeuralNetwork average(NeuralNetwork other);
	
	public int getNumInputs() {
		return inputs.length;
	}
	
	public int getNumOutputs() {
		return outputs.length;
	}
	
	public InputNode[] getInputNodes() {
		return this.inputs;
	}
	
	public OutputNode[] getOutputNodes() {
		return this.outputs;
	}

	public abstract void mutate(float mutationRate, float mutationAmount);
}
