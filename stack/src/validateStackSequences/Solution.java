package validateStackSequences;

import java.util.Stack;

/**
 * @author: itsuki
 * @create: 2021-06-03 10:52
 **/
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int length = pushed.length;
        if (length <= 1) return true;
        Stack<Integer> stack = new Stack<>();
        int popIdx = 0;
        for (int push : pushed) {
            stack.push(push);
            while (!stack.isEmpty() && stack.peek() == popped[popIdx]) {
                stack.pop();
                popIdx++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] poped = new int[]{4, 5, 3, 1, 2};
        System.out.println(new Solution().validateStackSequences(pushed, poped));
    }
}
