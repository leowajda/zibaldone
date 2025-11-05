package cracking_the_coding_interview.ch_02;

public class ReturnKthToLast {

    private static Node kthToLast(Node head, int k) {
        Node slow = head, fast = head;

        for (int i = 0; i < k; i++)
            if (fast == null) return null;
            else              fast = fast.next;

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

}
