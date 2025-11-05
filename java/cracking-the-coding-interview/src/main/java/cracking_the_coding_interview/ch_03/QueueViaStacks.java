package cracking_the_coding_interview.ch_03;

import java.util.EmptyStackException;

public class QueueViaStacks {

    private final IntStack stack, reverseStack;

    public QueueViaStacks() {
        this.stack        = new IntStack();
        this.reverseStack = new IntStack();
    }

    public void add(int value) {
        stack.push(value);
    }

    public int remove() {
        if (isEmpty())
            throw new EmptyStackException();

        if (!reverseStack.isEmpty())
            return reverseStack.pop();

        flipStacks();
        return reverseStack.pop();
    }

    public int peek() {
        if (isEmpty())
            throw new EmptyStackException();

        if (!reverseStack.isEmpty())
            return reverseStack.peek();

        flipStacks();
        return reverseStack.peek();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return stack.getSize() + reverseStack.getSize();
    }

    private void flipStacks() {
        while (!stack.isEmpty())
            reverseStack.push(stack.pop());
    }

}
