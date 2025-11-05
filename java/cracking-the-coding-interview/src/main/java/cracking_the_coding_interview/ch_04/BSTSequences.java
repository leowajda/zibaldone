package cracking_the_coding_interview.ch_04;

import java.util.ArrayList;
import java.util.List;

public class BSTSequences {

    private static List<List<Integer>> bstSequences(TreeNode root) {
        List<List<Integer>> bstSequences = new ArrayList<>();

        if (root == null) {
            bstSequences.add(new ArrayList<>());
            return bstSequences;
        }

        var leftBstSequences  = bstSequences(root.left);
        var rightBstSequences = bstSequences(root.right);

        for (var leftBstSequence: leftBstSequences)
            for (var rightBstSequence: rightBstSequences) {
                List<Integer> prefix = new ArrayList<>(List.of(root.val));
                backtrack(bstSequences, leftBstSequence, 0, rightBstSequence, 0, prefix);
            }

        return bstSequences;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> left, int leftPtr, List<Integer> right, int rightPtr, List<Integer> prefix) {

        if (leftPtr == left.size() && rightPtr == right.size()) {
            result.add(new ArrayList<>(prefix));
            return;
        }

        if (leftPtr < left.size()) {
            int leftVal = left.get(leftPtr);
            prefix.addLast(leftVal);
            backtrack(result, left, leftPtr + 1, right, rightPtr, prefix);
            prefix.removeLast();
        }

        if (rightPtr < right.size()) {
            int rightVal = right.get(rightPtr);
            prefix.addLast(rightVal);
            backtrack(result, left, leftPtr, right, rightPtr + 1, prefix);
            prefix.removeLast();
        }

    }

}
