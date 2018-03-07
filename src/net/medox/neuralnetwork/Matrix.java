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
	
	public void randomize(){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				data[i][j] = (int)Math.floor((float)(Math.random()) * 10);
			}
		}
	}
	
	public void add(Matrix m){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				data[i][j] += m.data[i][j];
			}
		}
	}
	
	public void add(float f){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				data[i][j] += f;
			}
		}
	}
	
	public void multiply(Matrix m){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				data[i][j] *= m.data[i][j];
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
	
	public void print(){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				System.out.print(data[i][j] + " ");
		    }
			System.out.println();
		}
	}
}
