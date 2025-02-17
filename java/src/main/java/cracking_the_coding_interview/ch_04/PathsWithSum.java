package cracking_the_coding_interview.ch_04;

import java.util.HashMap;
import java.util.Map;

public class PathsWithSum {

    public int pathSum(TreeNode root, int targetSum) {
        return helper(root, 0, targetSum, new HashMap<>());
    }

    private int helper(TreeNode root, int prefixSum, int targetSum, Map<Integer, Integer> counter) {

        if (root == null) return 0;
        prefixSum += root.val;

        int count = counter.getOrDefault(prefixSum - targetSum, 0);
        count += prefixSum == targetSum ? 1 : 0;

        counter.merge(prefixSum, 1, Integer::sum);
        count += helper(root.left, prefixSum, targetSum, counter);
        count += helper(root.right, prefixSum, targetSum, counter);
        counter.merge(prefixSum, -1, Integer::sum);

        return count;
    }

}
