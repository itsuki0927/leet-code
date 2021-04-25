package maxNumber;

import java.util.Arrays;

/**
 * 解题思路: 使用单调栈来取得数组中k个数字的最大值序列, 然后使用merge归并思想进行
 *
 * @author: itsuki
 * @create: 2021-04-24 11:03
 **/
public class Solution {
    private static int[] maxArr(int[] nums, int k) {
        int n = nums.length, top = 0;
        int[] stack = new int[n];
        // 丢弃的数量
        int dropNum = n - k;
        if (k == 0) return new int[n];

        for (int i = 0; i < n; i++) {
            // 如果栈不为空 && 可以丢弃数 > 0 && 当前数 > 栈顶元素
            while (top > 0 && dropNum > 0 && nums[i] > stack[top - 1]) {
                top--;
                dropNum--;
            }
            stack[top++] = nums[i];
        }
        top -= dropNum;

        return Arrays.copyOfRange(stack, 0, top);
    }

    // 归并
    private static int[] merge(int[] n1, int[] n2, int k) {
        int[] ret = new int[k];
        for (int i = 0, j = 0, l = 0; l < k; l++) {
            ret[l] = compare(n1, i, n2, j) ? n1[i++] : n2[j++];
        }
        return ret;
    }

    // 比较
    private static boolean compare(int[] n1, int i, int[] n2, int j) {
        while (i < n1.length && j < n2.length && n1[i] == n2[j]) {
            i++;
            j++;
        }
        return j == n2.length || (i < n1.length && n1[i] > n2[j]);
    }

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ret = new int[k];
        int m = nums1.length, n = nums2.length;
        for (int i = Math.max(0, k - n); i <= k && i <= m; i++) {
            int[] arr = merge(maxArr(nums1, i), maxArr(nums2, k - i), k);
            if (compare(arr, 0, ret, 0)) ret = arr;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{3, 4, 6, 5}, n2 = new int[]{6, 1, 10, 5, 8, 3};
        int[] ret = maxNumber(n1, n2, 5);
        System.out.println(Arrays.toString(ret));
    }
}
