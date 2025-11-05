package cracking_the_coding_interview.ch_02;

public class Partition {

    private static Node partition(Node node, int value) {

        Node headLow = null, currLow = null;
        Node headTop = null, currTop = null;

        while (node != null) {
            Node currNode = node;
            node = node.next;
            currNode.next = null;

            if (currNode.val < value) {

                if (headLow == null) {
                    headLow = currNode;
                    currLow = headLow;
                    continue;
                }

                currLow.next = currNode;
                currLow = currLow.next;
            }
            else {

                if (headTop == null) {
                    headTop = currNode;
                    currTop = headTop;
                    continue;
                }

                currTop.next = currNode;
                currTop = currTop.next;
            }

        }

        if (headTop == null) return headLow;
        if (headLow  == null) return headTop;
        currLow.next = headTop;

        return headLow;
    }

}
