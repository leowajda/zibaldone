package cracking_the_coding_interview.ch_01;

public class PalindromePermutation {

    private static boolean isPalindromePermutation(String s) {

        int bitMask = 0b0;
        // assumes ASCII in range 'a' - 'z'
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a';
            bitMask ^= (1 << val);
        }

        return bitMask == 0 || ((bitMask & (bitMask - 1)) == 0);
    }

}
