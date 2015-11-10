package asst1;

import java.util.Arrays;

public class MathMatrix extends MathObject {
	/**
	 * Matrix (2D dynamic array)
	 */
	protected double [][] matrixArray;
	/**
	 * Constructor
	 * @param m 2D array to store as the matrix
	 */
	public MathMatrix(double[][] m){
		this.matrixArray = m;
	}
	/**
	 * Multiply the matrix by a scalar
	 * @param scal Scalar to multiply the matrix
	 * @return MathMatrix that contains the matrix multiplied by the scalar
	 */
	public MathMatrix multiply(MathScalar scal) {
		int size = this.matrixArray.length;
		double[][] a = new double[size][size];
		MathMatrix m = new MathMatrix(a);
		for (int i=0; i<size; i++)
			for (int j=0; j<size; j++)
				m.matrixArray[i][j] = this.matrixArray[i][j]*scal.scalarValue;
		return m;
	}
	/**
	 * Get the number of rows in the matrix
	 * @return number of rows in the matrix array
	 */
	public int getRows() {
		return this.matrixArray.length;
	}
	/**
	 * Get the number of columns in the matrix
	 * @return number of columns in the matrix array
	 */
	public int getColumns() {
		return this.matrixArray[0].length;
	}
	/**
	 * Multiply two matrices
	 * @param mat Matrix to be multiplied
	 * @return MathMatrix which contains the product of the initial matrix and
	 * the parameter
	 * @throws MathException if the two matrices provided do not have compatible dimensions
	 */
	public MathMatrix multiply(MathMatrix mat) throws MathException {
		if(this.getColumns() != mat.getRows()){ throw new MathException();}
		double[][] a = new double[this.getRows()][mat.getColumns()];
		double sum;
		
		for (int i=0; i<getRows(); i++) {
			for (int j=0; j<mat.getColumns(); j++) {
				sum=0;
				for (int k=0; k<getColumns(); k++) {
					sum += this.matrixArray[i][k]*mat.matrixArray[k][j];
				}
				a[i][j] = sum;
			}
				
		}	
		MathMatrix retMat = new MathMatrix(a);
		return retMat;
	}
	/**
	 * equals method overridden for MathMatrix
	 * @param o the reference object with which to compare
	 * @return true if the two MathMatrix are equal; <p>false otherwise
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof MathMatrix) {
			MathMatrix m = (MathMatrix)o;
			return this.matrixArray == m.matrixArray;
		}
		else
			return false;
	}
	/**
	 * toString method overridden for MathMatrix
	 * <p>Used for printing
	 * @return Values of the matrix indices
	 */
	@Override
	public String toString() {
		return Arrays.deepToString(this.matrixArray);
	}

}
