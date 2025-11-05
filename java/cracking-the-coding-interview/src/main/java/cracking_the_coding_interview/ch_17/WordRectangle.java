package cracking_the_coding_interview.ch_17;

import java.util.*;

public class WordRectangle {

    private static class TrieNode {
        Map<Character, TrieNode> next;
        boolean isEndWord;
        char ch;

        public TrieNode(char ch) {
            this.next = new HashMap<>();
            this.ch = ch;
        }

        public void add(String word) {
            TrieNode tmp = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                tmp = tmp.next.computeIfAbsent(ch, TrieNode::new);
                if (i == word.length() - 1) tmp.isEndWord = true;
            }
        }
    }

    private List<String> solution;
    private int maxLength;
    private int maxArea;

    private List<String> wordRectangle(List<String> words) {
        Map<Integer, Set<String>> wordsByLength = new HashMap<>();
        TrieNode root = new TrieNode('#');
        maxArea = 0;

        for (var word : words) {
            int n = word.length();
            maxLength = Math.max(maxLength, n);
            var set = wordsByLength.computeIfAbsent(n, any -> new HashSet<>());
            set.add(word);
            root.add(word);
        }

        List<String> rectangle = new ArrayList<>();
        for (var entry : wordsByLength.entrySet()) {
            int length = entry.getKey();
            var list   = entry.getValue();
            rectangle.clear();
            backtrack(list, length, root, rectangle);
        }

        return solution == null ? Collections.emptyList() : solution;
    }

    private void backtrack(Set<String> words, int wordLength, TrieNode root, List<String> rectangle) {
        if (wordLength * maxLength < maxArea)   return; // pruning
        if (rectangle.size() > maxLength)       return;

        for (var word : words) {
            rectangle.addLast(word);
            var validation = validateRectangle(rectangle, wordLength, root);
            boolean areColumnsValid = validation.getFirst();
            boolean isValidSolution = validation.getLast();

            if (areColumnsValid) {
                int currArea = rectangle.size() * wordLength;
                if (isValidSolution && currArea > maxArea) {
                    maxArea = currArea;
                    solution = new ArrayList<>(rectangle);
                }

                backtrack(words, wordLength, root, rectangle);
            }

            rectangle.removeLast();
        }
    }

    private List<Boolean> validateRectangle(List<String> rectangle, int wordLength, TrieNode root) {

        boolean isValidSolution = true;
        for (int i = 0; i < wordLength; i++) {
            TrieNode tmp = root;

            for (int j = 0; j < rectangle.size(); j++) {
                var word = rectangle.get(j);
                var ch   = word.charAt(i);
                tmp = tmp.next.get(ch);
                if (tmp == null) return List.of(false, false);
            }

            if (!tmp.isEndWord) isValidSolution = false;
        }

        return List.of(true, isValidSolution);
    }

}




