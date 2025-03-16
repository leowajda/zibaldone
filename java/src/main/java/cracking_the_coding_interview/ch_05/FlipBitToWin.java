package cracking_the_coding_interview.ch_05;

public class FlipBitToWin {

    private static int flipBitToWin(int num) {

        int maxLength = 0, zeroPos = -1;
        for (int leftPtr = 0, rightPtr = 0; rightPtr < 32; rightPtr++) {
            if ((num & (1 << rightPtr)) == 0) {
                leftPtr = zeroPos + 1;
                zeroPos = rightPtr;
            }
            maxLength = Math.max(maxLength, rightPtr - leftPtr + 1);
        }

        return maxLength;
    }

}
