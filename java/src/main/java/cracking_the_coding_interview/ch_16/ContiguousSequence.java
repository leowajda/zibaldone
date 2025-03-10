package cracking_the_coding_interview.ch_16;

public class ContiguousSequence {

    private static int contiguousSequence(int[] nums) {

        int maxSum = 0, prevSum = 0;
        for (var num : nums) {
            prevSum = Math.max(prevSum + num, num);
            maxSum  = Math.max(maxSum, prevSum);
        }

        return maxSum;
    }

}
