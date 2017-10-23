package com.entropicbox.geneticfish.neuralnetwork;

import static org.junit.Assert.*;

import org.junit.Test;

public class NeuralNetworkTest {

	@Test
	public void testSimpleSingleLayerPerceptron() {
		NeuralNetwork simpleSingleLayerPerceptron = NeuralNetworkTestUtils.generateSimpleSingleLayerPerceptron();
		
		//	Predict based on some value
		float[] prediction = simpleSingleLayerPerceptron.predict(new float[] { 1.0f, -1.0f });
		
		//	(1.0*0.2) + (-1.0*-0.3) - (0.5),
		// =(.2) + (.3) - (-.5)
		// =1.0
		
		//	(1.0*0.4) + (-1.0*-0.5) - (-0.5)
		// =(.4) + (.5) - (-.5)
		// =(1.4)
		assertTrue( prediction[0] == 0.0f && prediction[1] == 1.4f );
	}
	
}
