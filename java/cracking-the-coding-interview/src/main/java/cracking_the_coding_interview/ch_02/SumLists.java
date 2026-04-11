package cracking_the_coding_interview.ch_02;

public class SumLists {

    private static Node sum(Node a, Node b) {

        Node c = new Node(-1);
        Node aPtr = a, bPtr = b, cPtr = c;

        int carry = 0;
        while (aPtr != null || bPtr != null) {

            int aVal = (aPtr == null) ? 0 : aPtr.val;
            int bVal = (bPtr == null) ? 0 : bPtr.val;

            carry += aVal + bVal;
            cPtr.next = new Node(carry % 10);
            cPtr = cPtr.next;
            carry /= 10;

            if (aPtr != null) aPtr = aPtr.next;
            if (bPtr != null) bPtr = bPtr.next;
        }

        if (carry != 0) cPtr.next = new Node(carry);
        return c.next;
    }

}
