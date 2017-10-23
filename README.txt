Introduction:
	This is an attempt to implement and better understand genetic algorithms and their applications in deep learning.
	The program starts with a random pool of members, where each member has an x, y location and neural network
	The neural network is a simple single layer perceptron, with 2 input and 2 output nodes
	The x, y location is random and the neural network is random as well on member creation
	The members are represented as blue squares
	Members are told of a goal, represented by the red circle,
	and a fitness function, which is the distance to the goal.
	They are trying to minimize their distance function, thus minimizing the distance to the goal.
	Each generation has n ticks/chances of movement before being evaluated.
	The top 50% are kept and bred to form a new 'bottom' 50%, through weighted averaging.
	Also, there is a chance of mutation when the new children are created, 
	this is done to reduce the likelihood of hitting a local minimum
	The SingleLayerPerceptron class uses recursion, so it should be easy to implement a MultiLayerPerceptron class and add some hidden layers!
	
Where to start:
	I would start at looking at the test cases, starting in the neuralnetwork package, then the member package, then the world
	package, lastly the game package.
	The game package has the fewest test cases, so the next best place to look is in the actual Game.java class
	All configuration is in the GameFactory.java class in static final variables.
	
	Play around with the config variables (change the mutation rate to 100% for example, or the mutation amount to 1)
	
	The SingleLayerPerceptron class uses recursion, so it should be easy to implement a MultiLayerPerceptron class and add some hidden layers!

Organization:
	main - All source code
	test - All test cases
	lib - All libraries (if any)
	bin - Class file output
	
I hope someone finds this as interesting as I did!