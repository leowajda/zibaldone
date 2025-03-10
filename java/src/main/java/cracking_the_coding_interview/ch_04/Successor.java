package cracking_the_coding_interview.ch_04;

public class Successor {

    private static TreeNode inOrderSuccessor(TreeNode node) {
        if (node == null) return null;

        if (node.right != null)
            return bstMinimum(node.right);

        TreeNode parent = node.parent, child = node;
        while (parent != null && child == parent.right) {
            child  = parent;
            parent = parent.parent;
        }

        return parent;
    }

    private static TreeNode bstMinimum(TreeNode root) {
        TreeNode node = root;
        while (node.left != null)
            node = node.left;
        return node;
    }

}
