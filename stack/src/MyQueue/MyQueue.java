package MyQueue;

import java.util.Stack;

/**
 * @author: itsuki
 * @create: 2021-06-03 10:38
 **/
public class MyQueue {
    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    private void shift() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        pushStack.add(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!popStack.isEmpty()) {
            return popStack.pop();
        }
        shift();
        return popStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!popStack.isEmpty()) {
            return popStack.peek();
        }
        shift();
        return popStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return popStack.empty() && pushStack.empty();
    }
}
