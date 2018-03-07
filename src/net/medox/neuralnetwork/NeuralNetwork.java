package net.medox.neuralnetwork;

public class NeuralNetwork{
	private int numInputNodes;
	private int numHiddenNodes;
	private int numOutputNodes;
	
	private Matrix weightsIH;
	private Matrix weightsHO;
	
	public NeuralNetwork(int numInputNodes, int numHiddenNodes, int numOutputNodes){
		this.numInputNodes = numInputNodes;
		this.numHiddenNodes = numHiddenNodes;
		this.numOutputNodes = numOutputNodes;
		
		weightsIH = new Matrix(this.numHiddenNodes, 1);
		weightsHO = new Matrix(this.numOutputNodes, 1);
	}
}
