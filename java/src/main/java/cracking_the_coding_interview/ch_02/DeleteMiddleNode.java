package cracking_the_coding_interview.ch_02;

public class DeleteMiddleNode {

    private static boolean deleteMiddleNode(Node node) {
        if (node == null || node.next == null)
            return false;

        node.val  = node.next.val;
        node.next = node.next.next;
        return true;
    }

}
