package cracking_the_coding_interview.ch_08;

import java.util.*;

public class Parens {

    private static List<String> parens(int n) {
        List<String> parens = new ArrayList<>();
         helper(n, n, parens, new ArrayDeque<>(n));
        return parens;
    }

    private static void helper(int openBrackets, int closedBrackets, List<String> parens, Deque<String> deque) {

        if (openBrackets == 0 && closedBrackets == 0) {
            parens.add(String.join("", deque));
            return;
        }

        if (openBrackets > 0) {
            deque.addLast("(");
            helper(openBrackets - 1, closedBrackets, parens, deque);
            deque.removeLast();
        }

        if (openBrackets < closedBrackets) {
            deque.addLast(")");
            helper(openBrackets, closedBrackets - 1, parens, deque);
            deque.removeLast();
        }

    }

}
