package cracking_the_coding_interview.ch_16;

import java.util.Arrays;

public class SmallestDifference {

    private static int findSmallestDifference(int[] a, int[] b) {

        int diff = Integer.MAX_VALUE;
        Arrays.sort(a);
        Arrays.sort(b);

        int aPtr = 0, bPtr = 0;
        while (aPtr < a.length && bPtr < b.length) {

            if (Math.abs(a[aPtr] - b[bPtr]) < diff)
                diff = Math.abs(a[aPtr] - b[bPtr]);

            if (a[aPtr] > b[bPtr]) bPtr++; else aPtr++;
        }

        return diff;
    }

}
