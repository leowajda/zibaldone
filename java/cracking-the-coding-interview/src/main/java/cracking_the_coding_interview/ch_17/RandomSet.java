package cracking_the_coding_interview.ch_17;

public class RandomSet {

    private static int randomNum(int from, int to) {
        return from + (int) (Math.random() * (to - from + 1));
    }

    private static int[] randomSet(int[] nums, int m) {
        int[] randomSet = new int[m];
        System.arraycopy(nums, 0, randomSet, 0, m);

        int n = nums.length;
        for (int i = m; i < n; i++) {
            int j = randomNum(0, i);
            if (j < m) randomSet[j] = nums[i];
        }

        return randomSet;
    }

}
