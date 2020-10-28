package ejercicios;

import java.util.Arrays;

/**
 * This class contains various methods for manipulating and compute analytics
 * from unidimensional and bidimensional Arrays.
 * 
 * <p>
 * Methods in this class all will not throw Exceptions if the specified array
 * reference is null. Instead, null will be returned.
 * 
 * @author Adri�n Garrido Blanco
 *
 */
public class Compute {

	/**
	 * Method that extracts the main diagonal from a square matrix.
	 * <p>
	 * If the condition is not met (matrix must be square), an empty matrix is
	 * returned.
	 * 
	 * @param m Matrix from which its main diagonal will be obtained.
	 * 
	 * @return diagonal If m is square.
	 */
	public static int[] diagonal(int[][] m) {

		int diagonal[] = new int[m.length];

		if (m.length == m[0].length) {
			for (int i = 0; i < diagonal.length; i++) {
				diagonal[i] = m[i][i];
			}
			return diagonal;
		}

		return null;
	}

	/**
	 * Method that extracts a secondary diagonal from a square matrix.
	 * <p>
	 * If the condition is not met (matrix must be square), an empty matrix is
	 * returned.
	 * 
	 * @param m            Matrix from which its secondary diagonal will be
	 *                     obtained.
	 * @param esSecundaria Boolean that manage if diagonal is secondary or not.
	 * 
	 * @return diagonal If m is square.
	 */
	public static int[] diagonal(int[][] m, boolean esSecundaria) {

		int diagonal[] = new int[m.length];

		if (m.length == m[0].length && esSecundaria == true) {
			for (int i = 0; i < diagonal.length; i++) {
				diagonal[i] = m[i][m.length - 1 - i];
			}
		}
		return diagonal;
	}

	/**
	 * Method that receives an Array A [] and copies its content in reverse to
	 * another Array B [].
	 * 
	 * @param array Initial Array.
	 * 
	 * @return aux Final inverted Array.
	 */
	public static int[] invertir(int[] array) {

		int[] aux = new int[array.length];
		int cont = 0;
		for (int i = aux.length - 1; i >= 0; i--) {
			aux[i] = array[cont++];
		}
		return aux;
	}

	/**
	 * Given an array m, it will return, whenever possible, the chosen row from the
	 * array indicated by the index parameter.
	 * <p>
	 * If the condition is not met (index in bounds of m.lenght), an empty array is
	 * returned.
	 * 
	 * @param m     Matrix you want to get the row from.
	 * @param index Index used to locate desired row.
	 * 
	 * @return aux Array that contains desired row.
	 */
	public static int[] getFila(int[][] m, int index) {

		int aux[] = new int[m[0].length];
		if (index < m.length) {
			aux = Arrays.copyOf(m[index], m[index].length);
		}

		return aux;
	}

	/**
	 * Given an array m, it will return, whenever possible, the chosen column from
	 * the array indicated by the index parameter.
	 * <p>
	 * If condition is not met (index in bounds of m[0]-lenght), an empty array is
	 * returned.
	 * 
	 * @param m     Matrix you want to get the column from.
	 * @param index Index used to locate desired column.
	 *
	 * @return column Array that contains desired c olumn.
	 */
	public static int[] getColumna(int m[][], int index) {

		int column[] = new int[m.length];

		if (index < m[0].length) {
			for (int i = 0; i < column.length; i++) {
				column[i] = m[i][index];
			}
		}
		return column;
	}

	/**
	 * Method that extracts a subMatrix from a given matrix.
	 * 
	 * @param m           Matrix you want to get a subMatrix.
	 * @param chossenRows Array that contains desired row index.
	 * @param chossenCols Array that contains desired col index.
	 * 
	 * @returns subMatrix SubMatrix from original matrix.
	 * @returns null If any of chossenRows or chossenCols are out of bounds of m.
	 */
	public static int[][] submatriz(int[][] m, int[] chossenRows, int[] chossenCols) {
		int[][] subMatrix = new int[chossenRows.length][chossenCols.length];

		int rowIt = 0;
		int colIt = 0;
		
		for (int i = 0; i < subMatrix.length; i++) {
			for (int j = 0; j < subMatrix[0].length; j++) {
				
				if (rowIt < chossenRows.length && colIt < chossenCols.length) {
					
					if (chossenRows[rowIt] < m.length && chossenCols[colIt] < m[0].length)						
						subMatrix[i][j] = m[chossenRows[rowIt]][chossenCols[colIt++]];
					
					else {
						
						if (chossenRows[rowIt] >= m.length && chossenCols[colIt] < m[0].length)
							System.out.println(chossenRows[rowIt] + " row index is not on bounds.");
						if (chossenRows[rowIt] < m.length && chossenCols[colIt] >= m[0].length)
							System.out.println(chossenCols[colIt] + " col index is not on bounds.");
						
						return null;
					}
				}
			}
			rowIt++;
			colIt = 0;
		}
		return subMatrix;
	}

	/**
	 * Method that multiply two matrix if they are compatible. 
	 * <p>
	 * If the condition is not met (matrix dimensions must be compatible), an empty matrix is returned.
	 * 
	 * @param m1 First matrix.
	 * @param m2 Second matrix.
	 * @return sum Multiplication outcome.
	 */
	public static int[][] multiplica(int[][] m1, int[][] m2) {

		int[][] sum = new int[m1.length][m2[0].length];

		if (m1[0].length == m2.length) {
			
			for (int i = 0; i < sum.length; i++) {
				for (int j = 0; j < sum[0].length; j++) {
					for (int k = 0; k < m1[0].length; k++) {
						
						sum[i][j] += m1[i][k] * m2[k][j];
					}
				}
			}
		}
		return sum;
	}

	/**
	 * Method that compute MinValue, MaxValue, Mean, StandardDeviation and Variance
	 * from a matrix.
	 * 
	 * @param m matrix you want to know its stats.
	 * @return stats Compound of stats from m.
	 */
	public static double[] extraerEstadisticas(int[][] m) {

		double[] stats = { computeMin(m), computeMax(m), computeMean(m), computeVarianceOfPopulation(m),
				computeStandardDeviation(m) };

		return stats;
	}

	/**
	 * Private method wich compute MaxValue of a matrix.
	 * 
	 * @param m Matrix of which you want to know its maximum value.
	 * @return max MaxValue of m.
	 */
	private static int computeMax(int[][] m) {

		int max = 0;
		// Compute max value.
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				
				if (m[i][j] > max)
					max = m[i][j];
			}
		}
		return max;
	}

	/**
	 * Private method which compute MinValue of a matrix.
	 * 
	 * @param m Matrix of which you want to know its minimum value.
	 * @return min MinValue of m.
	 */
	private static int computeMin(int[][] m) {

		int min = m[0][0];
		// Compute min value.
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				
				if (m[i][j] < min)
					min = m[i][j];
			}
		}
		return min;
	}

	/**
	 * Method that compute StandardDeviation of a matrix. Note that in this case the
	 * data is assumed to come from a population.
	 * 
	 * If you want to work with data from a sample, you can look at its formula at
	 * this method comments. Or you can switch {@code computeVariancePopulation} to
	 * {@code computeVarianceSample}.
	 * 
	 * @param Matrix of which you want to know its StandardDeviation.
	 * @return ValueOf StandardDeviation of m.
	 */
	private static double computeStandardDeviation(int[][] m) {
		// StandardDeviation equals to square root of Variance.
		return Math.sqrt(computeVarianceOfPopulation(m));
	}

	/**
	 * Method that compute Variance of a matrix. Note that data is assumed to come
	 * from a population, not a sample.
	 * 
	 * 
	 * @param m Matrix of which you want to know its Variance.
	 * @return ValueOf Variance of m.
	 */
	private static double computeVarianceOfPopulation(int[][] m) {

		double mean = computeMean(m), squaredDiff = 0;

		// 1 - Sum squared differences with mean.
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				squaredDiff += (m[i][j] - mean) * (m[i][j] - mean);
			}
		}

		// 2 - Variance equals to squared diff slash number of elements.
		return squaredDiff / 9;
	}

	/**
	 * Method that compute Variance of a matrix. Note that data is assumed to come
	 * from a sample, not a population.
	 * 
	 * @param m Matrix of which you want to know its Variance.
	 * @return ValueOf Variance of m.
	 */

	public static double computeVarianceOfSample(int[][] m) {

		double mean = computeMean(m), squaredDiff = 0;

		// 1 - Sum squared differences with mean.
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				squaredDiff += (m[i][j] - mean) * (m[i][j] - mean);
			}
		}

		// 2 - Variance equals to squared diff slash number of elements.
		return squaredDiff / (m.length * m[0].length - 1);
	}

	/**
	 * Method that compute Mean of a matrix.
	 * 
	 * @param m Matrix which you want to know its Mean.
	 * @return mean Mean of m.
	 */
	private static double computeMean(int[][] m) {

		double mean;
		int aux = 0;

		// Compute mean (average) - sum of elements slash number of elements.
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {				
				aux += m[i][j];
			}
		}
		mean = (double) aux / (m.length * m[0].length);
		return mean;
	}


	/**
	 * Method that rotate a matrix clockwise by 90 degrees.
	 * 
	 * @param m Original Matrix.
	 * @return rotatedMatrix Rotated Matrix clockwise by 90�.
	 */
	public static int[][] rotate90Clockwise(int[][] m) {

		int row = m[0].length; // Total columns of Original Matrix
		int col = m.length; // Total rows of Original Matrix

		int[][] rotatedMatrix = new int[row][col];

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				rotatedMatrix[j][(col - 1) - i] = m[i][j];
			}
		}
		return rotatedMatrix;
	}
	
	/**
	 * Method that rotate a matrix counter clockwise by 90 degrees.
	 * 
	 * @param m Original Matrix.
	 * 
	 * @return rotatedMatrix Rotated Matrix counter clockwise by 90�.
	 */
	public static int[][] rotated90CounterClockwise(int[][] m) {

		// Rotated Matrix row = Original Matrix col and viceversa.
		int row = m[0].length;
		int col = m.length;

		int[][] rotatedMatrix = new int[row][col];

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				rotatedMatrix[(row - 1) - j][i] = m[i][j];
			}
		}
		return rotatedMatrix;
	}
}