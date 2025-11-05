package cracking_the_coding_interview.ch_08;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StackOfBoxes {

    private static int stackOfBoxes(int[][] boxes) {

        int maxHeight = 0;
        int n = boxes.length;
        int[] memo = new int[n];

        Arrays.sort(boxes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++)
                if (boxes[j][1] < boxes[i][1] && boxes[j][2] < boxes[i][2])
                    memo[i] = Math.max(memo[i], memo[j]);

            memo[i] += boxes[i][2];
            maxHeight = Math.max(maxHeight, memo[i]);
        }

        return maxHeight;
    }

}
