package cracking_the_coding_interview.ch_17;

import java.util.Arrays;

public class MissingNumber {

    // book author presents an over-engineered solution because doesn't want to admit that integer size is in fact constant and not log(n).
    // also, the bit indexing requirement is complete bs...
    private static int missingNumber(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int n   = nums.length;
        return (n * (n + 1) / 2) - sum;
    }
}
