package com.entropicbox.geneticfish.neuralnetwork;

public class NeuralNetworkTestUtils {
	public static NeuralNetwork generateSimpleSingleLayerPerceptron() {
		//	Build the simple input nodes
		InputNode[] inputNodes = new InputNode[] { new InputNode(), new InputNode() };
		
		//	Build the weights for the input nodes
		float[] weightForOutNode1 = new float[] {.2f, -.3f};
		float[] weightForOutNode2 = new float[] {.4f, -.5f};
		
		//	Build the output nodes from the inputs and weights
		OutputNode[] outputNodes = new OutputNode[]{ new OutputNode(inputNodes, weightForOutNode1, .5f), new OutputNode(inputNodes, weightForOutNode2, -.5f) };
		
		//	Build the neural network based on the input and output nodes
		NeuralNetwork testNetwork = new SingleLayerPerceptron(inputNodes, outputNodes);

		return testNetwork;
	}
	
	public static NeuralNode[] generateSimpleSubnet() {
		NeuralNode inputNode = new InputNode();
		OutputNode outputNode = new OutputNode(new NeuralNode[]{inputNode}, new float[] {.8f}, .5f);
		return new NeuralNode[] {inputNode, outputNode}; 
	}
	
	public static OutputNode[] getHusbandWifeNodes() {
		NeuralNetwork net = generateSimpleSingleLayerPerceptron();
		return net.getOutputNodes();
	}
}
