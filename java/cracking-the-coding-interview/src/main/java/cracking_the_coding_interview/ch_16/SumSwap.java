package cracking_the_coding_interview.ch_16;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class SumSwap {

    private static int[] sumSwap(int[] a, int[] b) {
        int aSum = IntStream.of(a).sum();
        int bSum = IntStream.of(b).sum();

        int target = aSum - bSum;
        if (target % 2 != 0) return new int[] { };

        Set<Integer> bNums = new HashSet<>();
        IntStream.of(b).forEach(bNums::add);
        target /= 2;

        for (var aNum : a) {
            int diff = aNum - target;
            if (bNums.contains(diff)) return new int[] { aNum, diff };
        }

        return new int[] { };
    }

}
