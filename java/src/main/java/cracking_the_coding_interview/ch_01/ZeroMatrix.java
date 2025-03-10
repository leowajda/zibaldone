package cracking_the_coding_interview.ch_01;

import java.util.Arrays;

public class ZeroMatrix {

    private static void zeroMatrix(int[][] matrix) {

        boolean isFirstRowZero = false, isFirstColZero = false;
        int rows = matrix.length, cols = matrix[0].length;

        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                if (matrix[row][col] == 0) {
                    if (row == 0) isFirstRowZero = true;
                    if (col == 0) isFirstColZero = true;

                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }

        for (int row = 1; row < rows; row++)
            if (matrix[row][0] == 0)
                Arrays.fill(matrix[row], 0);

        for (int col = 1; col < cols; col++)
            if (matrix[0][col] == 0)
                for (int row = 1; row < rows; row++) matrix[row][col] = 0;

        if (isFirstRowZero) Arrays.fill(matrix[0], 0);
        if (isFirstColZero) for (int row = 1; row < rows; row++) matrix[row][0] = 0;
    }

}
