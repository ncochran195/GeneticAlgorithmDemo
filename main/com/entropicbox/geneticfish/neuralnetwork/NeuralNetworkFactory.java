package com.entropicbox.geneticfish.neuralnetwork;

import java.util.Random;

public class NeuralNetworkFactory {

	//	Builds a randomly generated single layer perceptron
	public static NeuralNetwork buildRandomSingleLayerPerceptron(int numInputs, int numOutputs) {
		InputNode[] inputs;
		OutputNode[] outputs;

		Random r = new Random();
		float rangeMin = -1.0f;
		float rangeMax = 1.0f;
		
		//	Build the input nodes
		inputs = new InputNode[numInputs];
		for (int i = 0; i < numInputs; i++) {
			inputs[i] = new InputNode();
		}
		
		//	Build the output nodes
		outputs = new OutputNode[numOutputs];
		for (int i = 0; i < numOutputs; i++) {
			
			//	Build random weight for each input
			float[] childWeights = new float[numInputs];
			for (int j = 0; j < numInputs; j++) {
				childWeights[j] = rangeMin + (rangeMax - rangeMin) * r.nextFloat();
			}
			
			float bias = rangeMin + (rangeMax - rangeMin) * r.nextFloat();
			outputs[i] = new OutputNode(inputs, childWeights, bias);
		}
		
		return new SingleLayerPerceptron(inputs, outputs);
	}

	public static NeuralNetwork weightedAverageSingleLayerPerceptrons(NeuralNetwork husband, NeuralNetwork wife, float weight) {
		//	Generate new input nodes
		InputNode[] newInputs = new InputNode[husband.inputs.length];
		for (int i = 0; i < newInputs.length; i++) {
			newInputs[i] = new InputNode();
		}
			
		//	Generate new output nodes
		OutputNode[] newOutputs = new OutputNode[husband.outputs.length];
		for (int i = 0; i < newOutputs.length; i++) {
			newOutputs[i] = averageBiasAndWeights(husband.outputs[i], wife.outputs[i], newInputs, weight);
			newOutputs[i].setChildren(newInputs);
		}

		//	Build new perceptron
		return new SingleLayerPerceptron(newInputs, newOutputs);
	}
	
	//	This builds a new node, which is a weighted average of this node, 
	public static OutputNode averageBiasAndWeights(OutputNode husband, OutputNode wife, InputNode[] children, float averageWeight) {
		
		//	Calculate 
		float biasDelta = averageWeight*(wife.getBias() - husband.getBias());
		float newBias = husband.getBias() + biasDelta;
		
		float[] newWeights = new float[husband.getWeights().length];
		for (int i = 0; i < husband.getWeights().length; i++) {
			float weightDelta = averageWeight*(wife.getWeights()[i] - husband.getWeights()[i]);
			newWeights[i] = husband.getWeights()[i] + weightDelta;
		}
		
		OutputNode newNode = new OutputNode(children, newWeights, newBias);
		return newNode;
	}

}
