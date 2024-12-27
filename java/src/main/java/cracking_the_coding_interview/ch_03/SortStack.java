package cracking_the_coding_interview.ch_03;

public class SortStack {

    private final IntStack stack, placeholder;

    public SortStack() {
        this.stack       = new IntStack();
        this.placeholder = new IntStack();
    }

    public void push(int value) {

        while (!stack.isEmpty() && value > stack.peek())
            placeholder.push(stack.pop());

        stack.push(value);

        while (!placeholder.isEmpty())
            stack.push(placeholder.pop());

    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
