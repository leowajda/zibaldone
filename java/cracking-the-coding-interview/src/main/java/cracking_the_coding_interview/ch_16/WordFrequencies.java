package cracking_the_coding_interview.ch_16;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequencies {

    private static class Node {

        public Map<Character, Node> children;
        public int frequency;
        public Character ch;

        public Node(Character ch) {
            this.children  = new HashMap<>('z' - 'a');
            this.frequency = 0;
            this.ch = ch;
        }

        public void add(String word) {

            Node node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                node = node.children.computeIfAbsent(ch, Node::new);
                if (i == word.length() - 1) node.frequency++;
            }

        }

        public int getFrequency(String word) {

            Node node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.children.containsKey(ch)) return -1;
                else                                node = node.children.get(ch);
                if (i == word.length() - 1)         return node.frequency;
            }

            return -1;
        }

    }

    private static final Node root = new Node('#');

    private static List<Integer> wordFrequencies(List<String> words) {
        words.forEach(root::add);
        return words.stream().map(root::getFrequency).toList();
    }

}
