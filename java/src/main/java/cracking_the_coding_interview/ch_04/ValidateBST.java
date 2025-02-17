package cracking_the_coding_interview.ch_04;

public class ValidateBST {

    private static boolean isValidBST(TreeNode root) {
        return helper(Integer.MIN_VALUE, root, Integer.MAX_VALUE);
    }

    private static boolean helper(int min, TreeNode node, int max) {
        if (node == null) return true;
        boolean isNodeWithinBounds  = min <= node.val && node.val < max;
        boolean isLeftWithinBounds  = helper(min, node.left, node.val);
        boolean isRightWithinBounds = helper(node.val, node.right, max);
        return isNodeWithinBounds && isLeftWithinBounds && isRightWithinBounds;
    }

}
