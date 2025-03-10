package cracking_the_coding_interview.ch_08;

public class TripleStep {

    private static int tripleStep(int n) {
        int a = 1, b = 2, c = 4;
        if (n <= 3) return n == 3 ? c : n;

        for (int i = 4; i <= n; i++) {
            int d = a + b + c;
            a = b;
            b = c;
            c = d;
        }

        return c;
    }

}
