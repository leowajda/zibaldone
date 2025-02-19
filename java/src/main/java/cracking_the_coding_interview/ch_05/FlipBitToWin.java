package cracking_the_coding_interview.ch_05;

import java.util.Arrays;

public class FlipBitToWin {

    private static int flipBitToWin(int num) {

        int[] array = Arrays.stream(Integer.toBinaryString(num)
                .split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxLength = 0, zeroPos = -1;
        for (int leftPtr = 0, rightPtr = 0; rightPtr < array.length; rightPtr++) {
            if (array[rightPtr] == 0) {
                leftPtr = zeroPos + 1;
                zeroPos = rightPtr;
            }
            maxLength = Math.max(maxLength, rightPtr - leftPtr + 1);
        }

        return maxLength;
    }

}
