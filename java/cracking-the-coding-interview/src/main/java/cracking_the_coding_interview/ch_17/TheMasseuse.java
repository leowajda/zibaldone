package cracking_the_coding_interview.ch_17;

import java.util.stream.IntStream;

public class TheMasseuse {

    private static int theMasseuse(int[] appointments) {

        int n = appointments.length;
        if (n <= 2) return IntStream.of(appointments).max().orElse(-1);

        int a = appointments[0], b = appointments[1];
        for (int i = 2; i < n; i++) {
            int c = Math.max(b, a + appointments[i]);
            a = b;
            b = c;
        }

        return b;
    }

}
