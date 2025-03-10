package cracking_the_coding_interview.ch_08;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PowerSet {

    private static List<List<Integer>> powerSet(List<Integer> nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res, 0, new ArrayDeque<>());
        return res;
    }

    private static void helper(List<Integer> nums, List<List<Integer>> res, int index, Deque<Integer> stack) {

        if (index == nums.size()) {
            res.add(new ArrayList<>(stack));
            return;
        }

        stack.push(nums.get(index));
        helper(nums, res, index + 1, stack);
        stack.pop();
        helper(nums, res, index + 1, stack);
    }

}
