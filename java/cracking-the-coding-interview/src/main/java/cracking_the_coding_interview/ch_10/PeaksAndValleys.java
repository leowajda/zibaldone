package cracking_the_coding_interview.ch_10;

import java.util.Arrays;

public class PeaksAndValleys {

    // will correctly handle cases with duplicates like [5, 5, 5, 5, 9, 9, 9], the solution from the book is wrong.
    private static void peaksAndValleys(int[] nums) {
        Arrays.sort(nums);
        int leftPtr = 1, rightPtr = nums.length - 1;

        while (leftPtr <= rightPtr) {

            int tmp = nums[leftPtr];
            nums[leftPtr] = nums[rightPtr];
            nums[rightPtr] = tmp;

            leftPtr  += 2;
            rightPtr -= 2;
        }

    }

}
