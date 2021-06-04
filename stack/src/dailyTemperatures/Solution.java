package dailyTemperatures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: itsuki
 * @create: 2021-06-04 15:30
 **/
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < length; i++) {
            while (!deque.isEmpty() && temperatures[deque.peek()] < temperatures[i]) {
                int index = deque.poll();

                result[index] = i - index;
            }
            deque.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
