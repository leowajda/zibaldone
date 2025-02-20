package cracking_the_coding_interview.ch_08;

public class RecursiveMultiply {

    // the recursion requirement is left for the reader's imagination
    private static int multiply(int a, int b) {
        int multipliedNum = 0;
        while (b > 0) {
            if ((b & 1) == 1)
                multipliedNum += a;

            b >>= 1;
            a <<= 1;
        }
        return  multipliedNum;
    }

}
