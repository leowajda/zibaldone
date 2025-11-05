package cracking_the_coding_interview.ch_17;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ContinuousMedian {

    private final Queue<Integer> left;
    private final Queue<Integer> right;
    private boolean isEven;

    public ContinuousMedian() {
        this.left = new PriorityQueue<>(Comparator.reverseOrder());
        this.right = new PriorityQueue<>(Comparator.naturalOrder());
        this.isEven = true;
    }

    public void addNum(int num) {
        if (isEven) {
            right.add(num);
            left.add(right.remove());
        } else {
            left.add(num);
            right.add(left.remove());
        }
        isEven = !isEven;
    }

    public double findMedian() {
        if (left.size() > right.size()) return left.peek();
        return ((left.peek() + right.peek()) / 2.0);
    }

}
