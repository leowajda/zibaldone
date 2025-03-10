package cracking_the_coding_interview.ch_03;

public class StackMin {

    private IntStack stack;
    private IntStack minStack;

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(val, min()));
    }

    public int min() {
        return minStack.peek();
    }

    public int peek() {
        return stack.peek();
    }

    public int pop() {
        int val = stack.pop();
        minStack.pop();
        return val;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

}
