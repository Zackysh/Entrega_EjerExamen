package ejercicios;

import java.util.Arrays;

/**
 * This class contains various methods for manipulating and compute analytics
 * from unidimensional and bidimensional Arrays.
 * 
 * <p>
 * Methods in this class all throw {@code java.lang.NullPointerException} if the
 * specified array reference is null.
 * 
 * @author Adrián Garrido Blanco
 *
 */
public class Compute {

	/**
	 * Method that extracts the main diagonal from a square matrix.
	 * 
	 * @param m Matrix from which its main diagonal will be obtained.
	 * 
	 * @throws java.lang.NullPointerException if given isn't square. it causes a
	 *                                        null reference.
	 * @return diagonal IF m is square.
	 * @return null IF m isn't square.
	 */
	public static int[] diagonal(int[][] m) {

		int row = m.length, col = m[0].length;
		int diagonal[];

		if (row == col) {
			diagonal = new int[m.length];
			for (int i = 0; i < diagonal.length; i++) {
				diagonal[i] = m[i][i];
			}
			return diagonal;
		} else {
			System.out.println("Solo las matrices cuadradas tienen diagonal.");
			return null;
		}
	}

	/**
	 * Method that extracts a secondary diagonal from a square matrix.
	 * 
	 * @param m            Matrix from which its secondary diagonal will be
	 *                     obtained.
	 * @param esSecundaria Boolean that manage if diagonal is secondary or not.
	 * 
	 * @throws java.lang.NullPointerException If given matrix isn't square.
	 * 
	 * @return diagonal IF m is square.
	 * @return null IF m isn't square.
	 */
	public static int[] diagonal(int[][] m, boolean esSecundaria) {

		int row = m.length, col = m[0].length;
		int diagonal[];

		if (row == col && esSecundaria == true) {
			diagonal = new int[m.length];
			for (int i = 0; i < diagonal.length; i++) {
				diagonal[i] = m[i][row - 1 - i];
			}
			return diagonal;
		} else {
			return null;
		}
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
	 * 
	 * @param m     Matrix you want to get the row from.
	 * @param index Index used to locate desired row.
	 * 
	 * @throws java.lang.ArrayIndexOutOfBoundsException if you specify an index out
	 *                                                  of range.
	 * @return aux Array that contains desired row.
	 */
	public static int[] getFila(int[][] m, int index) {

		int aux[] = Arrays.copyOf(m[index], m[index].length);

		return aux;

	}

	/**
	 * Given an array m, it will return, whenever possible, the chosen column from
	 * the array indicated by the index parameter.
	 * 
	 * @param m     Matrix you want to get the column from.
	 * @param index Index used to locate desired column.
	 * 
	 * @throws java.lang.ArrayIndexOutOfBoundsException if you specify an index out
	 *                                                  of range.
	 * @return
	 */
	static int[] getColumna(int m[][], int index) {

		int column[] = new int[m.length];

		for (int i = 0; i < column.length; i++) {
			column[i] = m[i][index];
		}

		return column;
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	/**
	 * Method that compute MinValue, MaxValue, Mean, StandardDeviation and Variance
	 * from a matrix.
	 * 
	 * @param m matrix you want to know its stats.
	 * @return stats Compound of stats from m.
	 */
	public static double[] extraerEstadisticas(int[][] m) {

		double[] stats = { computeMin(m), computeMax(m), computeMean(m), computeVariancePopulation(m),
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

		int row = m.length, col = m[0].length, max = m[0][0];
		// Compute max value.
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
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

		int row = m.length, col = m[0].length, min = m[0][0];
		// Compute min value.
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
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
		return Math.sqrt(computeVariancePopulation(m));
	}

	/**
	 * Method that compute Variance of a matrix. Note that data is assumed to come
	 * from a population, not a sample.
	 * 
	 * 
	 * @param m Matrix of which you want to know its Variance.
	 * @return ValueOf Variance of m.
	 */
	private static double computeVariancePopulation(int[][] m) {

		int row = m.length, col = m[0].length;
		double mean = computeMean(m), squaredDiff = 0;

		// 1 - Sum squared differences with mean.
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
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
	@SuppressWarnings("unused")
	private static double computeVarianceSample(int[][] m) {

		int row = m.length, col = m[0].length;
		double mean = computeMean(m), squaredDiff = 0;

		// 1 - Sum squared differences with mean.
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				squaredDiff += (m[i][j] - mean) * (m[i][j] - mean);
			}
		}

		// 2 - Variance equals to squared diff slash number of elements.
		return squaredDiff / (row * col - 1);
	}

	/**
	 * Method that compute Mean of a matrix.
	 * 
	 * @param m Matrix which you want to know its Mean.
	 * @return mean Mean of m.
	 */
	private static double computeMean(int[][] m) {
		double mean;
		int row = m.length, col = m[0].length, aux = 0;

		// Compute mean (average) - sum of elements slash number of elements.
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				aux += m[i][j];
			}
		}
		mean = (double) aux / (row * col);
		return mean;
	}

	/**
	 * Experimental method.
	 * It came from the depths of my inspiration.
	 * @param m
	 */
	@SuppressWarnings("unused")
	private static void rotate90Clockwise(int[][] m) {

		int row = m[0].length; // Total columns of Original Matrix
		int col = m.length; // Total rows of Original Matrix

		int[][] rotatedMatrix = new int[row][col];

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				rotatedMatrix[j][(col - 1) - i] = m[i][j];
			}
		}

	}

}
