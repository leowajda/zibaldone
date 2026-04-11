package cracking_the_coding_interview.ch_05;

public class PairWiseSwap {

    private static final int ODD_BITS  = 0xAAAAAAAA;
    private static final int EVEN_BITS = 0x55555555;

    private static int pairWiseSwap(int num) {
        return ((num & ODD_BITS >>> 1) | (num & EVEN_BITS << 1));
    }

}
