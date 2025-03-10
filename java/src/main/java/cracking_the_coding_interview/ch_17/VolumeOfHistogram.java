package cracking_the_coding_interview.ch_17;

public class VolumeOfHistogram {

    private static int volumeOfHistogram(int[] height) {

        int n = height.length;
        int maxLeft = 0, maxRight = 0;
        int leftPtr = 0, rightPtr = n - 1;

        int res = 0;
        while (leftPtr <= rightPtr)
            if (maxLeft <= maxRight) {
                res += Math.max(0, maxLeft - height[leftPtr]);
                maxLeft = Math.max(maxLeft, height[leftPtr]);
                leftPtr++;
            } else {
                res += Math.max(0, maxRight - height[rightPtr]);
                maxRight = Math.max(maxRight, height[rightPtr]);
                rightPtr--;
            }

        return res;
    }

}
