package merge;

import java.util.Arrays;

/**
 * @author: itsuki
 * @create: 2021-06-07 10:24
 **/
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int[] nums3 = new int[m];
        // 只需要把 nums1 的有效个元素复制到 nums3 就可以了
        System.arraycopy(nums1, 0, nums3, 0, m);

        int i = 0, j = 0, length = m + n;
        for (int k = 0; k < length; k++) {
            if (i == m) {
                nums1[k] = nums2[j];
                j++;
            } else if (j == n) {
                nums1[k] = nums3[i];
                i++;
            } else if (nums3[i] < nums2[j]) {
                nums1[k] = nums3[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{2, 0};
        int[] n2 = new int[]{1};
        new Solution().merge(n1, 1, n2, 1);
        System.out.println(Arrays.toString(n1));
    }
}
