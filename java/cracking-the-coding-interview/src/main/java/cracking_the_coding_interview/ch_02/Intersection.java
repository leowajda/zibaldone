package cracking_the_coding_interview.ch_02;

public class Intersection {

    private static Node getIntersectionNode(Node a, Node b) {

        Node aPtr = a, bPtr = b;

        // both pointers eventually traverse the same amount of nodes A + B
        while (aPtr != bPtr) {
            aPtr = (aPtr == null) ? b : aPtr.next;
            bPtr = (bPtr == null) ? a : bPtr.next;
        }

        return aPtr;
    }

}
