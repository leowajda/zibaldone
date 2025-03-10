package cracking_the_coding_interview.ch_17;

import java.util.Arrays;

public class MaxSubMatrix {

    private record SubMatrix(int rowStart, int rowEnd, int colStart, int colEnd, int sum) {}
    private record Range(int start, int end, int sum) {}

    private static SubMatrix maxSubMatrix(int[][] matrix) {

        int n = matrix.length;
        SubMatrix maxSubMatrix = null;
        int[] partialSum = new int[n];

        for (int rowStart = 0; rowStart < n; rowStart++) {
            for (int rowEnd = rowStart; rowEnd < n; rowEnd++) {
                for (int col = 0; col < n; col++)
                    partialSum[col] += matrix[rowEnd][col];

                var maxSubArray = maxSubArray(partialSum);
                if (maxSubMatrix == null || maxSubArray.sum > maxSubMatrix.sum)
                    maxSubMatrix = new SubMatrix(rowStart, maxSubArray.start, rowEnd, maxSubArray.end, maxSubArray.sum);
            }
            Arrays.fill(partialSum, 0);
        }

        return maxSubMatrix;
    }

    private static Range maxSubArray(int[] nums) {

        int start = 0;
        int sum = nums[0];
        int n = nums.length;
        Range maxSubArray = null;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (maxSubArray == null || sum > maxSubArray.sum)
                maxSubArray = new Range(start, i, sum);

            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }

        return maxSubArray;
    }

}
