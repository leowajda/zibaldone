package cracking_the_coding_interview.ch_04;

public class MinimalTree {

    private static TreeNode minimalTree(int[] array) {
        return helper(array, 0, array.length - 1);
    }

    private static TreeNode helper(int[] array, int start, int end) {
        if (start > end)
            return null;

        int middle = start + (end - start) / 2;
        var node   = new TreeNode(array[middle]);
        node.left  = helper(array, start, middle - 1);
        node.right = helper(array, middle + 1, end);
        return node;
    }



}
