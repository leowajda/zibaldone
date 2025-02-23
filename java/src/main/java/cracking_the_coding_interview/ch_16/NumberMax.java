package cracking_the_coding_interview.ch_16;

public class NumberMax {

    private static int max(int a, int b) {
        int diff        = a - b;
        int isNegative  = (diff >> 31) & 0x1;
        return a - (diff * isNegative);
    }

}
