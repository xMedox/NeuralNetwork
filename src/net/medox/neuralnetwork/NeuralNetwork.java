package net.medox.neuralnetwork;

import java.util.Arrays;

public class NeuralNetwork{
	private int numInputNodes;
	private int numHiddenNodes;
	private int numOutputNodes;
	
	private Matrix weightsIH;
	private Matrix weightsHO;
	
	private Matrix biasH;
	private Matrix biasO;
	
	private float learningRate;
	
	public NeuralNetwork(int numInputNodes, int numHiddenNodes, int numOutputNodes){
		this.numInputNodes = numInputNodes;
		this.numHiddenNodes = numHiddenNodes;
		this.numOutputNodes = numOutputNodes;
		
		weightsIH = new Matrix(this.numHiddenNodes, this.numInputNodes);
		weightsHO = new Matrix(this.numOutputNodes, this.numHiddenNodes);
		weightsIH.randomize();
		weightsHO.randomize();
		
		biasH = new Matrix(this.numHiddenNodes, 1);
		biasO = new Matrix(this.numOutputNodes, 1);
		biasH.randomize();
		biasO.randomize();
		
		learningRate = 0.1f;
	}
	
	public void setLearningRate(float learningRate){
		this.learningRate = learningRate;
	}
	
	public float[] predict(float[] input){
		Matrix inputs = Matrix.fromArray(input);
		Matrix hidden = Matrix.multiply(this.weightsIH, inputs);
		hidden.add(biasH);
		hidden.sigmoid();
		
		Matrix output = Matrix.multiply(weightsHO, hidden);
		output.add(biasO);
		output.sigmoid();
		
		return Matrix.toArray(output);
	}
	
	public void train(float[] input, float[] target){
		Matrix inputs = Matrix.fromArray(input);
		Matrix hidden = Matrix.multiply(this.weightsIH, inputs);
		hidden.add(biasH);
		hidden.sigmoid();
		
		Matrix output = Matrix.multiply(weightsHO, hidden);
		output.add(biasO);
		output.sigmoid();
		
		
		Matrix targets = Matrix.fromArray(target);
		Matrix outputErrors = Matrix.subtract(targets, output);
		
		Matrix gradients = Matrix.alreadySigmoided(output);
		gradients.multiply(outputErrors);
		gradients.multiply(learningRate);
		
		Matrix hiddenT = Matrix.transpose(hidden);
		Matrix weightHODeltas = Matrix.multiply(gradients, hiddenT);
		
		weightsHO.add(weightHODeltas);
		biasO.add(gradients);
		
		
		Matrix whoT = Matrix.transpose(weightsHO);
		Matrix hiddenErrors = Matrix.multiply(whoT, outputErrors);
		
		Matrix hiddenGradient = Matrix.alreadySigmoided(hidden);
		hiddenGradient.multiply(hiddenErrors);
		hiddenGradient.multiply(learningRate);
		
		Matrix inputsT = Matrix.transpose(inputs);
		Matrix weightIHDeltas = Matrix.multiply(hiddenGradient, inputsT);
		
		weightsIH.add(weightIHDeltas);
	    biasH.add(hiddenGradient);
	}
	
	public static void main(String[] args){
		NeuralNetwork nn = new NeuralNetwork(2, 10, 1);
		
		System.out.println(Arrays.toString(nn.predict(new float[]{0f, 1f})));
		System.out.println(Arrays.toString(nn.predict(new float[]{1f, 0f})));
		System.out.println(Arrays.toString(nn.predict(new float[]{1f, 1f})));
		System.out.println(Arrays.toString(nn.predict(new float[]{0f, 0f})));
		
		int epoch = 4;
		for(int i = 0; i < epoch; i++){
			System.out.println("training");
			
//			float learningRate = 1.0000001f;
			
			int train = 1000000;
			for(int j = 0; j < train; j++){
//				learningRate -= 0.0000001f;
//				if(learningRate <= 0.0000001f){
//					learningRate = 0.0000001f;
//				}
//				nn.setLearningRate(learningRate);
	//			System.out.println(learningRate);
				
				int random = 0 + (int)(Math.random() * ((4 - 0) + 1));
				
				if(random == 0){
					nn.train(new float[]{0f, 1f}, new float[]{1f});
				}else if(random == 1){
					nn.train(new float[]{1f, 0f}, new float[]{1f});
				}else if(random == 2){
					nn.train(new float[]{1f, 1f}, new float[]{0f});
				}else if(random == 3){
					nn.train(new float[]{0f, 0f}, new float[]{0f});
				}
			}
			
			System.out.println(Arrays.toString(nn.predict(new float[]{0f, 1f})));
			System.out.println(Arrays.toString(nn.predict(new float[]{1f, 0f})));
			System.out.println(Arrays.toString(nn.predict(new float[]{1f, 1f})));
			System.out.println(Arrays.toString(nn.predict(new float[]{0f, 0f})));
		}
		
//		Matrix m = new Matrix(2, 3);
//		
//		m.randomize();
//		m.print();
//		System.out.println();
//		
//		m.multiply(2);
//		m.print();
//		System.out.println();
//		
//		Matrix m2 = new Matrix(2, 3);
//		
//		m2.randomize();
//		m2.print();
//		System.out.println();
//		
//		m.add(m2);
//		m.print();
//		System.out.println();
//		
//		Matrix m3 = new Matrix(5, 1);
//		m3.randomize();
//		m3.print();
//		System.out.println();
//		
//		float[] f = Matrix.toArray(m3);
//		Matrix m4 = Matrix.fromArray(f);
//		m4.print();
//		System.out.println();
	}
}
