package net.medox.neuralnetwork;

public class Matrix{
	private int rows;
	private int cols;
	private float[][] data;
	
	public Matrix(int rows, int cols){
		this.rows = rows;
		this.cols = cols;
		data = new float[rows][cols];
	}
	
	public void add(float f){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				data[i][j] += f;
			}
		}
	}
	
	public void multiply(float f){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				data[i][j] *= f;
			}
		}
	}
}
