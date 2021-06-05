package nextGreaterElement;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author: itsuki
 * @create: 2021-06-05 08:01
 **/
public class Solution2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int[] result = new int[length1];
        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums2) {
            while (!deque.isEmpty() && deque.peekLast() < num) {
                hashMap.put(deque.pollLast(), num);
            }
            deque.offerLast(num);
        }

        for (int i = 0; i < length1; i++) {
            result[i] = hashMap.getOrDefault(nums1[i], -1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 4};
        int[] nums2 = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(new Solution2().nextGreaterElement(nums1, nums2)));
    }
}
