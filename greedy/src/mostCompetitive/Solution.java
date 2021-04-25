package mostCompetitive;

import java.util.Arrays;
import java.util.Stack;

/**
 * 解题思路: 单调栈
 *
 * @author: itsuki
 * @create: 2021-04-25 09:20
 **/
public class Solution {
    public static int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> deque = new Stack<>();
        int[] ret = new int[k];
        int dropNum = nums.length - k;
        for (int num : nums) {
            while (!deque.isEmpty() && deque.peek() > num && dropNum > 0) {
                deque.pop();
                dropNum--;
            }
            deque.push(num);
        }
        while (dropNum-- > 0) {
            deque.pop();
        }
        while (k > 0) {
            ret[--k] = deque.pop();
        }
        return ret;
    }

    public static void main(String[] args) {
//        int[] n = new int[]{2, 4, 3, 3, 5, 4, 9, 6};
        int[] n = new int[]{71, 18, 52, 29, 55, 73, 24, 42, 66, 8, 80, 2};
        System.out.println(Arrays.toString(mostCompetitive(n, 3)));
    }
}
