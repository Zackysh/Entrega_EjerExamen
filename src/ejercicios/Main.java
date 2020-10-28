package ejercicios;

public class Main {
	public static void main(String[] args) {

		int a[][] = { { 6, 7, 2 }, { 1, 1, 3 }, { 6, 7, 0 } };

		int b[] = { 2, 14, 4, 12 };

		int c[][] = { { 6, 7, 2, 2 },
					  { 1, 1, 3, 1 }, //
					  { 6, 7, 0, 6 }, //
					  { 6, 7, 0, 11 } };
		int[] rows = {1, 2};
		int[] cols = {0, 1, 2};

		int d[][] = Compute.submatriz(c, rows, cols);
		
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[0].length; j++) {
				System.out.print(d[i][j] + "  ");
			}
			System.out.println();
		}

	}
}
