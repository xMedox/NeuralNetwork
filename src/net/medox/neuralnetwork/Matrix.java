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
	
	public static Matrix fromArray(float[] f){
		Matrix m = new Matrix(f.length, 1);
		for(int i = 0; i < f.length; i++){
			m.data[i][0] = f[i];
		}
		return m;
	}
	
	public static float[] toArray(Matrix m){
		float[] f = new float[m.rows*m.cols];
		
		for(int i = 0; i < m.rows; i++){
			for(int j = 0; j < m.cols; j++){
				f[i+j*m.rows] = m.data[i][j];
			}
		}
		
		return f;
	}
	
	public static Matrix transpose(Matrix m){
		Matrix result = new Matrix(m.cols, m.rows);
		
		for(int i = 0; i < m.rows; i++){
			for(int j = 0; j < m.cols; j++){
				result.data[j][i] = m.data[i][j];
			}
		}
		
		return result;
	}
	
	public static Matrix subtract(Matrix m, Matrix m2){
		Matrix result = new Matrix(m.rows, m.cols);
		
		for(int i = 0; i < m.rows; i++){
			for(int j = 0; j < m.cols; j++){
				result.data[i][j] = m.data[i][j] - m2.data[i][j];
			}
		}
		return result;
	}
	
	public static Matrix multiply(Matrix m, Matrix m2){
		if(m.cols != m2.rows){
			System.out.print("Columns of m must match rows of m2");
			return null;
		}
		Matrix result = new Matrix(m.rows, m2.cols);
		
		for(int i = 0; i < result.rows; i++){
			for(int j = 0; j < result.cols; j++){
				float sum = 0;
				for(int k = 0; k < m.cols; k++){
					sum += m.data[i][k] * m2.data[k][j];
				}
				result.data[i][j] = sum;
			}
		}
		return result;
	}
	
	public void sigmoid(){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				float val = data[i][j];
				data[i][j] = (float)(1 / (1 + (float)Math.exp(-val)));
			}
		}
	}
	
	public static Matrix alreadySigmoided(Matrix m){
		Matrix result = new Matrix(m.rows, m.cols);
		
		for(int i = 0; i < result.rows; i++){
			for(int j = 0; j < result.cols; j++){
				float val = m.data[i][j];
				result.data[i][j] = (float)(val * (1 - val));
			}
		}
		return result;
	}
	
	public void randomize(){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				data[i][j] = (float)((float)Math.random() * 2 - 1);
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
