package cracking_the_coding_interview.ch_01;

import java.util.stream.IntStream;

public class CheckPermutation {

    private static boolean checkPermutation(String a, String b) {
        if (a.length() != b.length())
            return false;

        int[] counter = new int[128];
        int n = a.length();

        // assumes ASCII
        for (int i = 0; i < n; i++) {
            char aChar = a.charAt(i), bChar = b.charAt(i);
            counter[aChar]++;
            counter[bChar]--;
        }

        return IntStream.of(counter).allMatch(num -> num == 0);
    }

}
