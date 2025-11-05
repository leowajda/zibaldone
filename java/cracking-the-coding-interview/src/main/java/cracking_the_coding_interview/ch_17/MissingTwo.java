package cracking_the_coding_interview.ch_17;

import java.util.stream.IntStream;

public class MissingTwo {

    private static int[] missingTwo(int[] nums) {

        int targetN         = nums.length + 2;
        int actualTargetSum = IntStream.of(nums).sum();
        int targetDiff      = nSum(targetN) - actualTargetSum;

        int offset          = targetDiff / 2;
        int actualOffsetSum = IntStream.of(nums).filter(num -> num <= offset).sum();
        int offsetDiff      = nSum(offset) - actualOffsetSum;

        return new int[] { offsetDiff, targetDiff - offsetDiff };
    }

    private static int nSum(int n) {
        return n * (n + 1) / 2;
    }

}
