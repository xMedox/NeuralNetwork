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
		
		weightsIH = new Matrix(this.numHiddenNodes, this.numInputNodes);
		weightsHO = new Matrix(this.numOutputNodes, this.numHiddenNodes);
		weightsIH.randomize();
		weightsHO.randomize();
	}
	
	public static void main(String[] args){
		Matrix m = new Matrix(2, 3);
		
		m.randomize();
		m.print();
		System.out.println();
		
		m.multiply(2);
		m.print();
		System.out.println();
		
		Matrix m2 = new Matrix(2, 3);
		
		m2.randomize();
		m2.print();
		System.out.println();
		
		m.add(m2);
		m.print();
		System.out.println();
	}
}
