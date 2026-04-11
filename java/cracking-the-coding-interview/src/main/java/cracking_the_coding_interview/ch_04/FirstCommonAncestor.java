package cracking_the_coding_interview.ch_04;

public class FirstCommonAncestor {

    private static TreeNode firstCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || root == a || root == b)
            return root;

        var leftAncestor  = firstCommonAncestor(root.left, a, b);
        var rightAncestor = firstCommonAncestor(root.right, a, b);

        if (leftAncestor != null && rightAncestor != null) return root;
        return leftAncestor != null ? leftAncestor : rightAncestor;
    }

}
