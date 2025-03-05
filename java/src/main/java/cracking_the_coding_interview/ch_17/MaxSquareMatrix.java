package cracking_the_coding_interview.ch_17;

import java.util.stream.IntStream;

public class MaxSquareMatrix {

    private static int maxSubSquare(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] memo = new int[rows][cols];
        int maximalSquare = 0;

        for (int row = 0; row < rows; row++)
            if (matrix[row][cols - 1] == '1') {
                memo[row][cols - 1] = 1;
                maximalSquare = 1;
            }

        for (int col = 0; col < cols; col++)
            if (matrix[rows - 1][col] == '1') {
                memo[rows - 1][col] = 1;
                maximalSquare = 1;
            }

        for (int row = rows - 2; row >= 0; row--)
            for (int col = cols - 2; col >= 0; col--)
                if (matrix[row][col] == '1') {

                    int diagCell = memo[row + 1][col + 1];
                    int bottomCell = memo[row + 1][col];
                    int leftCell = memo[row][col + 1];

                    memo[row][col] = IntStream.of(diagCell, bottomCell, leftCell).min().orElseThrow() + 1;
                    maximalSquare = Math.max(maximalSquare, memo[row][col]);
                }


        return maximalSquare * maximalSquare;
    }

}
