package com.entropicbox.geneticfish.neuralnetwork;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NeuralNodeTest {

	@Test
	public void testInputNodeOutput() {
		//	Build the input node
		NeuralNode inputNode = new InputNode();
		
		//	Set the input of the node
		inputNode.setOutput(.1f);
		
		//	Get the output of the node
		float output = inputNode.calculateOutput();
		
		//	Should be the input value, .1
		assertTrue(output == .1f);
	}

	@Test
	public void testSimpleSubnet() {
		//	Build the input/output nodes w/ connection
		NeuralNode[] simpleSubnet = NeuralNetworkTestUtils.generateSimpleSubnet();
		
		//	Set the input of the simple network
		simpleSubnet[0].setOutput(.1f);

		//	Get the output of the simple network
		float output = simpleSubnet[1].calculateOutput();
		
		//	Should be (.1*.8)-.5
		assertTrue(output == -0.42f);
	}

	@Test
	public void testNodeAverage() {
		//	Get husband/wife
		OutputNode[] husbandWifeNodes = NeuralNetworkTestUtils.getHusbandWifeNodes();
		OutputNode husband = husbandWifeNodes[0];
		OutputNode wife = husbandWifeNodes[1];
		
		//	Get children
		OutputNode husbandsChild = NeuralNetworkFactory.averageBiasAndWeights(husband, wife, new InputNode[] {}, .1f);
		OutputNode wifesChild = NeuralNetworkFactory.averageBiasAndWeights(wife, husband, new InputNode[] {}, .1f);
		
		//	Test biases
		assertTrue(husbandsChild.getBias() == 0.4f);
		assertTrue(wifesChild.getBias() == -0.4f);
		
		//	Test weights
		assertTrue(husbandsChild.getWeights()[0] == 0.22f);
		assertTrue(husbandsChild.getWeights()[1] == -0.32000002f);
		
		assertTrue(wifesChild.getWeights()[0] == 0.38f);
		assertTrue(wifesChild.getWeights()[1] == -0.48f);
	}
}
