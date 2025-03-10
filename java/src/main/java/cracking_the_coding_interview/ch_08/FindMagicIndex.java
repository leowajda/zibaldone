package cracking_the_coding_interview.ch_08;

public class FindMagicIndex {

    private static int findMagicIndex(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static int helper(int[] nums, int left, int right) {
        if (left > right) return -1;

        int middle = left + (right - left) / 2;
        if (nums[middle] == middle)
            return middle;

        int leftMagicIndex = helper(nums, left, middle - 1);
        return leftMagicIndex != -1 ? leftMagicIndex : helper(nums, middle + 1, right);
    }

}
