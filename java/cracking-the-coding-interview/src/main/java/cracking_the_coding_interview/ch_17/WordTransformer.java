package cracking_the_coding_interview.ch_17;

import java.util.*;

public class WordTransformer {

    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (beginWord.equals(endWord))
            return 0;

        Queue<String> queue        = new ArrayDeque<>(List.of(beginWord));
        Set<String> availableWords = new HashSet<>(wordList);
        availableWords.remove(beginWord);

        int level = 1;
        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                var candidate = queue.remove();
                if (candidate.equals(endWord)) return level;

                for (var word : wordList)
                    if (isValidNeighbor(candidate, word) && availableWords.contains(word)) {
                        availableWords.remove(word);
                        queue.add(word);
                    }
            }

            level++;
        }

        return 0;
    }

    private static boolean isValidNeighbor(String from, String to) {
        int n = from.length();
        int countDiff = 0;

        for (int i = 0; i < n; i++) {
            if (from.charAt(i) != to.charAt(i)) countDiff++;
            if (countDiff > 1) break;
        }

        return countDiff == 1;
    }

}
