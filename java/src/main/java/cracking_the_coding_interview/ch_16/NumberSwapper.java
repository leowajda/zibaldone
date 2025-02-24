package cracking_the_coding_interview.ch_16;

public class NumberSwapper {

    private static void swap(int a, int b) {
        a ^= b; // diff patch
        b ^= a; // apply patch to `b`
        a ^= b; // remove patch from `a`
    }

}
