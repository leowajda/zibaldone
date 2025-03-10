package cracking_the_coding_interview.ch_02;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    private static void removeDuplicates(Node head) {
        Set<Integer> seen = new HashSet<>();
        Node prev = head;

        while (head != null) {
            if (seen.add(head.val)) prev = head;
            else                    prev.next = head.next;
            head = head.next;
        }
    }

}
