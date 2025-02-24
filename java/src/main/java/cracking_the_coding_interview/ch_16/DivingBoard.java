package cracking_the_coding_interview.ch_16;

import java.util.HashSet;
import java.util.Set;

public class DivingBoard {

    private static Set<Integer> divingBoard(int shortPlank, int longPlank, int k) {

        Set<Integer> lengths = new HashSet<>(shortPlank);
        for (int numShorter = 0; numShorter <= k; numShorter++) {
            int numLonger = k - numShorter;
            int length    = (numShorter * shortPlank) + (numLonger + longPlank);
            lengths.add(length);
        }

        return lengths;
    }

}
