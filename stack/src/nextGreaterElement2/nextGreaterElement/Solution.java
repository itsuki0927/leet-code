package nextGreaterElement2.nextGreaterElement;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: itsuki
 * @create: 2021-06-05 08:01
 **/
public class Solution {
    public int[] nextGreaterElement(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);
        // 单调递减栈
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < length * 2; i++) {
            int num = nums[i % length];
            while (!deque.isEmpty() && nums[deque.peekLast()] < num) {
                result[deque.pollLast()] = num;
            }
            if (i < length) {
                deque.offerLast(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100, 1, 11, 1, 120, 111, 123, 1, -1, -100};
        System.out.println(Arrays.toString(new Solution().nextGreaterElement(nums)));
    }
}
