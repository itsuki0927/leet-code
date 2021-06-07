package merge;

import java.util.Arrays;

/**
 * @author: itsuki
 * @create: 2021-06-07 10:24
 **/
public class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;

        int i = m - 1, j = n - 1, length = m + n;
        for (int k = length - 1; k >= 0; k--) {
            if (i == -1) {
                System.arraycopy(nums2, 0, nums1, 0, j + 1);
                break;
            } else if (j == -1) {
                break;
            } else if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{2, 0};
        int[] n2 = new int[]{1};
        new Solution2().merge(n1, 1, n2, 1);
        System.out.println(Arrays.toString(n1));
    }
}
