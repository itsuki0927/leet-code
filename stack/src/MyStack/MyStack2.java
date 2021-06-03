package MyStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: itsuki
 * @create: 2021-06-03 10:02
 **/
public class MyStack2 {
    Queue<Integer> data;

    /**
     * Initialize your data structure here.
     */
    public MyStack2() {
        data = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    // 通过临时队列反转
    public void push(int x) {
        int n = data.size();
        data.offer(x);
        for (int i = 0; i < n; i++) {
            data.offer(data.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return data.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return data.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return data.isEmpty();
    }
}