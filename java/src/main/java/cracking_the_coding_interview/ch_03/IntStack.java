package cracking_the_coding_interview.ch_03;

import java.util.EmptyStackException;

public class IntStack {

    private Node top;
    private int size;

    public IntStack() {
        this.top  = null;
        this.size = 0;
    }

    public void push(int val) {
        size++;

        if (top == null) {
            top = new Node(val);
            return;
        }

        Node prevTop = top;
        top          = new Node(val);
        top.next     = prevTop;
    }

    public int pop() {
        if (isEmpty())
            throw new EmptyStackException();

        size--;
        Node prevTop = top;
        top          = top.next;
        return prevTop.val;
    }

    public int peek() {
        if (isEmpty())
            throw new EmptyStackException();

        return top.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node tmp = top;

        sb.append("[");
        while (tmp != null) {
            sb.append(tmp.val);
            if (tmp.next != null) sb.append(",");
            tmp = tmp.next;
        }
        sb.append("]");

        return sb.toString();
    }
}
