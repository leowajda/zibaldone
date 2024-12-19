package cracking_the_coding_interview.ch_02;

public class LoopDetection {

    private static Node detectLoop(Node node) {

        Node slow = node, fast = node;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) break;
        }

        if (fast == null || fast.next == null)
            return null;

        slow = node;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}
