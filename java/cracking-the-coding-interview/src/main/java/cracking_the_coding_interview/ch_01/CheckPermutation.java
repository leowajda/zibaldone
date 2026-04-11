package cracking_the_coding_interview.ch_01;

import java.util.stream.IntStream;

public class CheckPermutation {

    private static boolean checkPermutation(String a, String b) {
        if (a.length() != b.length())
            return false;

        int[] counter = new int[128];

        // assumes ASCII
        for (int i = 0; i < a.length(); i++) {
            char aChar = a.charAt(i), bChar = b.charAt(i);
            counter[aChar]++;
            counter[bChar]--;
        }

        return IntStream.of(counter).allMatch(num -> num == 0);
    }

}
