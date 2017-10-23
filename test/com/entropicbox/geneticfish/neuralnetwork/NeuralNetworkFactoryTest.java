package com.entropicbox.geneticfish.neuralnetwork;

import static org.junit.Assert.*;

import org.junit.Test;

public class NeuralNetworkFactoryTest {

	@Test
	public void testRandomNeuralNetworkCreation() {
		NeuralNetwork network = NeuralNetworkFactory.buildRandomSingleLayerPerceptron(100, 100);
		assertTrue(network != null); 
	}
	
	@Test
	public void testInputOutputNodeCounts() {
		NeuralNetwork network = NeuralNetworkFactory.buildRandomSingleLayerPerceptron(100, 100);
		assertTrue(network.getNumInputs() == 100 && network.getNumOutputs() == 100); 	
	}
}
