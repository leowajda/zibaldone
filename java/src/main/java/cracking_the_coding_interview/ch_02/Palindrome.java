package cracking_the_coding_interview.ch_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Palindrome {

    private static boolean isPalindrome(Node node) {

        Node slow = node, fast = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Node reversePtr = reverse(fast != null ? slow.next : slow);
        Node nodePtr    = node;

        while (reversePtr != null) {
            if (reversePtr.val != nodePtr.val)
                return false;

            reversePtr = reversePtr.next;
            nodePtr    = nodePtr.next;
        }

        return true;
    }

    private static Node reverse(Node node) {

        Node prev = null, next = null;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }

}
