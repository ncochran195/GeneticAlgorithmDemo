package com.entropicbox.geneticfish.neuralnetwork;

import java.util.Arrays;


public class SingleLayerPerceptron extends NeuralNetwork {
	
	//	Builds a single layer perceptron with set inputs/outputs
	public SingleLayerPerceptron(InputNode[] inputs, OutputNode[] outputs) {
		super();

		this.inputs = inputs;
		this.outputs = outputs;
	}
		
	@Override
	public float[] predict(float[] inputValues) {
		//	Set the inputs for the input nodes
		for (int i = 0; i < inputs.length; i++) {
			inputs[i].setOutput(inputValues[i]);
		}
		
		//	For each output node, calculate the output and add to list
		float[] outputValues = new float[outputs.length];
		for (int i = 0; i < outputValues.length; i++) {
			outputValues[i] = outputs[i].calculateOutput(); 
		}
		
		return outputValues;
	}

	@Override
	public String toString() {
		return "SingleLayerPerceptron [inputs=" + Arrays.toString(inputs)
				+ ", outputs=" + Arrays.toString(outputs) + ", id=" + id + "]";
	}

	@Override
	public NeuralNetwork average(NeuralNetwork other) {
		return null;
	}

	@Override
	public void mutate(float mutationRate, float mutationAmount) {
		//	For each output,
		for (OutputNode outputNode : outputs) {
			outputNode.mutate(mutationRate, mutationAmount);
		}
	}
}
