package minStack;

/**
 * 解题思路: 链表
 *
 * @author: itsuki
 * @create: 2021-06-02 14:23
 **/
public class Solution2 {
    static class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min) {
            this(val, min, null);
        }

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    static class MinStack {
        Node head = null;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
        }

        public void push(int val) {
            if (head == null) {
                head = new Node(val, val);
            } else {
                head = new Node(val, Math.min(val, head.min), head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
    }
}
