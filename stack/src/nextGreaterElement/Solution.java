package nextGreaterElement;

import java.util.Arrays;

/**
 * @author: itsuki
 * @create: 2021-06-05 08:01
 **/
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        int length1 = nums1.length, length2 = nums2.length;

        for (int i = 0; i < length1; i++) {
            int element = nums1[i];
            int j = 0;
            // 在num2中找到element的位置
            while (j < length2 && nums2[j] != element) {
                j++;
            }

            j++;
            // num2中找到第一个大于element的位置
            while (j < length2 && nums2[j] < element) {
                j++;
            }
            // 如果不存在则-1
            if (j == length2) {
                result[i] = -1;
                continue;
            }
            result[i] = nums2[j];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 4};
        int[] nums2 = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(new Solution().nextGreaterElement(nums1, nums2)));
    }
}
