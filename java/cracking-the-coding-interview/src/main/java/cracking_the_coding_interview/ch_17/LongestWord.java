package cracking_the_coding_interview.ch_17;

import java.util.*;

public class LongestWord {

    private static String longestWord(List<String> words) {
        Set<String> dictionary    = new HashSet<>(words);
        Map<String, Integer> memo = new HashMap<>();

        words.forEach(word -> helper(word, memo, dictionary));

        String longestWord = "";
        int maxCounter = 0;

        for (var word : memo.entrySet())
            if (word.getValue() > maxCounter) {
                maxCounter = word.getValue();
                longestWord = word.getKey();
            }

        return longestWord;
    }

    private static int helper(String word, Map<String, Integer> memo, Set<String> dictionary) {
        if (memo.containsKey(word))
            return memo.get(word);

        int n = word.length();
        int counter = 0;

        for (int i = 1; i <= n; i++) {
            var a = word.substring(0, i);
            if (dictionary.contains(a)) {
                var b = i == n ? "" : word.substring(i);
                int bCounter = helper(b, memo, dictionary);
                if (b.isEmpty() || bCounter != 0) counter = Math.max(counter, 1 + bCounter);
            }
        }

        return memo.put(word, counter);
    }

}
