package cracking_the_coding_interview.ch_03;

import java.util.*;

public class StackOfPlates {

    private final List<IntStack> stacks;
    private final int stackCapacity;

     public StackOfPlates(int stackCapacity) {
         this.stacks        = new ArrayList<>();
         this.stackCapacity = stackCapacity;
     }

     public void push(int value) {
         var lastStack = getLastStack();

         if (lastStack != null && lastStack.getSize() < stackCapacity) {
             lastStack.push(value);
             return;
         }

         lastStack = new IntStack();
         lastStack.push(value);
         stacks.addLast(lastStack);
     }

    // popAt(int idx) requires Node to reference both the next and prev node.
    public int pop() {
         var lastStack = getLastStack();

         if (lastStack == null)
             throw new EmptyStackException();

         int value = lastStack.pop();

         if (lastStack.isEmpty())
             stacks.removeLast();

         return value;
     }

     private IntStack getLastStack() {
         if (stacks.isEmpty()) return null;
         return stacks.getLast();
     }

}
