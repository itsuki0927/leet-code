package minStack;

import java.util.Stack;

/**
 * 解题思路: 双栈
 *
 * @author: itsuki
 * @create: 2021-06-02 14:23
 **/
public class Solution {
    static class MinStack {
        Stack<Integer> data;
        Stack<Integer> minData;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            data = new Stack();
            minData = new Stack();
        }

        public void push(int val) {
            data.push(val);
            if (minData.isEmpty() || minData.peek() > val) {
                minData.push(val);
            } else {
                minData.push(minData.peek());
            }
        }

        public void pop() {
            data.pop();
            minData.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return minData.peek();
        }
    }
}
