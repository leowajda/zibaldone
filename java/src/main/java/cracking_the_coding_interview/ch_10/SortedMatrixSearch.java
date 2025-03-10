package cracking_the_coding_interview.ch_10;

public class SortedMatrixSearch {

    private static boolean search(int[][] matrix, int target) {

        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int middle    = left + (right - left) / 2;
            int middleVal = matrix[middle / cols][middle % cols];

            if (middleVal == target)
                return true;

            if (middleVal < target) left  = middle + 1;
            else                    right = middle - 1;
        }

        return false;
    }

}
