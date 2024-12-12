package cracking_the_coding_interview.ch_01;

public class RotateMatrix {

    private static void rotateMatrix(int[][] matrix) {

        int n = matrix.length;

        for (int row = 0; row < n / 2; row++) {
            int first = row, last = n - 1 - row;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top    = matrix[first][i];

                matrix[first][i]              = matrix[last - offset][first];
                matrix[last - offset][first]  = matrix[last][last - offset];
                matrix[last][last - offset]   = matrix[i][last];
                matrix[i][last]               = top;
            }
        }

    }

}
