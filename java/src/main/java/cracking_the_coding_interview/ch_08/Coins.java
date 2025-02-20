package cracking_the_coding_interview.ch_08;

import java.util.Arrays;
import java.util.List;

public class Coins {

    private static final List<Integer> COINS = List.of(25, 10, 5, 1);

    private static int coins(int n) {

        int[] memo = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;

        for (int i = 1; i <= n; i++)
            for (var coin : COINS) {
                if (i - coin < 0 || memo[i - coin] == Integer.MAX_VALUE) continue;
                memo[i] = Math.min(memo[i], memo[i - coin] + 1);
            }
        
        return memo[n] == Integer.MAX_VALUE ? -1 : memo[n];
    }

}
