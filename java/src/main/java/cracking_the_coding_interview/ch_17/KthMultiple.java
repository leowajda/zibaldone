package cracking_the_coding_interview.ch_17;

import java.util.stream.LongStream;

public class KthMultiple {

    public int kthMultiple(int k) {

        int[] multipliers   = { 3, 5, 7 };
        int[] pointers      = { 0, 0, 0 };
        long[] uglyNums     = new long[k];
        long[] candidates   = new long[3];

        uglyNums[0] = 1;
        for (int i = 1; i < k; i++) {

            for (int j = 0; j < candidates.length; j++)
                candidates[j] = uglyNums[pointers[j]] * multipliers[j];

            uglyNums[i] = LongStream.of(candidates).min().orElseThrow();

            for (int j = 0; j < candidates.length; j++)
                if (candidates[j] == uglyNums[i])
                    pointers[j]++;
        }

        return (int) uglyNums[k - 1];
    }

}
