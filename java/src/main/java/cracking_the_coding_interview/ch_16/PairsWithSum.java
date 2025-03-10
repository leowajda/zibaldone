package cracking_the_coding_interview.ch_16;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairsWithSum {

    // problem statement not very clear how duplicate pairs should be handled
    private static List<List<Integer>> pairsWithSum(int[] nums, int target) {
        List<List<Integer>> pairs   = new ArrayList<>();
        Set<Integer> visited        = new HashSet<>();

        for (var num : nums) {
            int diff = target - num;
            if (visited.contains(diff)) pairs.add(List.of(num, diff));
            visited.add(num);
        }

        return pairs;
    }

}
