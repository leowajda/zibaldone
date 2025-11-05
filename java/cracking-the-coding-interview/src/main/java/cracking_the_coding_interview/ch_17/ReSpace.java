package cracking_the_coding_interview.ch_17;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReSpace {

    private static int reSpace(String document, List<String> words) {

        Set<String> dictionary = new HashSet<>(words);
        int n = document.length();
        int[] memo = new int[n + 1];

        for (int i = n - 1; i >= 0; i--)
            for (int j = i; j < n; j++) {
                String substring = document.substring(i, j + 1);
                int m = substring.length();
                memo[i] = Math.max(memo[i], memo[j + 1] + (dictionary.contains(substring) ? m : 0));
            }

        return n - memo[0];
    }

}
