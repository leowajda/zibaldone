package cracking_the_coding_interview.ch_10;

public class SearchInRotatedArray {

    // assumes strictly monotonic function
    private static int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left <= right) {

            int middle = left + (right - left) / 2;
            if (nums[middle] == target) return middle;

            if (nums[left] > nums[middle] && target > nums[right]) {
                right = middle - 1;
                continue;
            }

            if (nums[right] < nums[middle] && target < nums[left]) {
                left = middle + 1;
                continue;
            }

            if (nums[middle] < target) left  = middle + 1;
            else                       right = middle - 1;
        }


        return -1;
    }

}
