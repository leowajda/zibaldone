package cracking_the_coding_interview.ch_17;

import java.util.stream.IntStream;

public class MajorityElement {

    private static int majorityElement(int[] nums) {
        int majorityNum = count(nums);
        int count = (int) IntStream.of(nums).filter(num -> num == majorityNum).count();
        return count > (nums.length / 2) ? majorityNum : -1;
    }

    private static int count(int[] nums) {

        int majorityNum = 0, counter = 0;
        for (var num : nums) {
            if (counter == 0)       majorityNum = num;
            counter += (num == majorityNum) ? 1 : -1;
        }

        return majorityNum;
    }

}
