package cracking_the_coding_interview.ch_04;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ListOfDepths {

    private static List<List<TreeNode>> listOfDepths(TreeNode root) {

        Queue<TreeNode> queue = new ArrayDeque<>(List.of(root));
        List<List<TreeNode>> listOfDepths = new ArrayList<>();

        while (!queue.isEmpty()) {

            int n = queue.size();
            List<TreeNode> listOfDepth = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                var node = queue.remove();
                listOfDepth.add(node);
                if (node.left != null)  queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            listOfDepths.add(listOfDepth);
        }

        return listOfDepths;
    }

}
