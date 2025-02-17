package cracking_the_coding_interview.ch_04;


/*

Implement a function to check if a binary tree is balanced.
For the purposes of this question, a balanced tree is defined to be a tree such that
the heights of the two subtrees of any node never differ by more than one.

*/
public class CheckBalanced {

    private static final int IMBALANCED_TREE_MARKER = Integer.MAX_VALUE;

    private static boolean isBalanced(TreeNode root) {
        return helper(root) != IMBALANCED_TREE_MARKER;
    }

    private static int helper(TreeNode root) {

        if (root == null)
            return 0;

        int leftDepth = helper(root.left);
        if (leftDepth == IMBALANCED_TREE_MARKER)  return leftDepth;

        int rightDepth = helper(root.right);
        if (rightDepth == IMBALANCED_TREE_MARKER) return rightDepth;

        int absDiff = Math.abs(leftDepth - rightDepth);
        return absDiff > 1 ? IMBALANCED_TREE_MARKER : Math.max(leftDepth, rightDepth) + 1;
    }

}
