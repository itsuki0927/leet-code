package MyStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: itsuki
 * @create: 2021-06-03 10:02
 **/
public class MyStack {
    Queue<Integer> data;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        data = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    // 通过临时队列反转
    public void push(int x) {
        Queue<Integer> temp = new LinkedList<>();
        if (data.isEmpty()) {
            data.offer(x);
        } else {
            temp.offer(x);
            while (!data.isEmpty()) {
                temp.offer(data.poll());
            }
            while (!temp.isEmpty()) {
                data.offer(temp.poll());
            }
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