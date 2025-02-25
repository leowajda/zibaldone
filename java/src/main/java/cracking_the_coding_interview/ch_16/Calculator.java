package cracking_the_coding_interview.ch_16;

import java.util.*;
import java.util.function.BiFunction;

public class Calculator {

    private static final Map<String, BiFunction<Double, Double, Double>> OPS = Map.of(
            "+", (a, b) -> a + b,
            "-", (a, b) -> a - b,
            "*", (a, b) -> a * b,
            "/", (a, b) -> a / b
    );

    private static Double calculate(String equation) {
        if (equation.isEmpty()) return 0.0;

        var parts = equation.split("(?=[*/+\\-])|(?<=[*/+\\-])");
        Deque<String> deque = new ArrayDeque<>(List.of(parts[0]));

        for (int i = 2; i < parts.length; i += 2) {
            var b   = parts[i];
            var a   = deque.removeLast();
            var op  = parts[i - 1];

            if (op.equals("*") || op.equals("/")) {
                if (op.equals("/") && b.equals("0"))
                    throw new IllegalArgumentException("division by zero");

                var c = solve(a, op, b);
                deque.addLast(c);
                continue;
            }

            deque.addLast(a);
            deque.addLast(op);
            deque.addLast(b);
        }

        while (deque.size() != 1) {
            var a   = deque.removeFirst();
            var op  = deque.removeFirst();
            var b   = deque.removeFirst();
            var c   = solve(a, op, b);
            deque.addFirst(c);
        }

        return Double.parseDouble(deque.remove());
    }

    private static String solve(String a, String op, String b) {
        var function = OPS.get(op);
        double aNum = Double.parseDouble(a);
        double bNum = Double.parseDouble(b);
        double cNum = function.apply(aNum, bNum);
        return String.valueOf(cNum);
    }

}
