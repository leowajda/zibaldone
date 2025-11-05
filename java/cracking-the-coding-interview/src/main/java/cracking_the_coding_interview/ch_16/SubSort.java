package cracking_the_coding_interview.ch_16;

public class SubSort {

    private static int[] subSort(int[] nums) {

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int leftPtr = -1, rightPtr = -1;
        int n = nums.length;

        for (int i = 0; i < n; i++)
            if (nums[i] >= max) max = nums[i];
            else                rightPtr = i;

        for (int i = n - 1; i >= 0; i--)
            if (nums[i] <= min) min = nums[i];
            else                leftPtr = i;

        return new int[] { leftPtr, rightPtr };
    }

}
