package cracking_the_coding_interview.ch_04;

public class CheckSubTree {

    private static boolean checkSubTree(TreeNode root, TreeNode subTree) {
        return isSame(root, subTree) || checkSubTree(root.left, subTree) || checkSubTree(root.right, subTree);
    }

    private static boolean isSame(TreeNode a, TreeNode b) {
        if (a == null || b == null)
            return a == b;
        return a.val == b.val && isSame(a.left, b.left) && isSame(a.right, b.right);
    }

}
