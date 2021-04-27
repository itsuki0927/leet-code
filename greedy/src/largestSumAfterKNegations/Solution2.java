package largestSumAfterKNegations;

import java.util.Arrays;

/**
 * @author: itsuki
 * @create: 2021-04-27 10:18
 **/
public class Solution2 {
    public static int largestSumAfterKNegations(int[] arr, int k) {
        Arrays.sort(arr); // asc: 负数...0..0..正数
        int sum = 0, len = arr.length, minIndex = 0; // 初始第一个最小
        while (k > 0) {
            arr[minIndex] *= -1; // 最小者取反
            k--;
            // 维护最小值索引
            // 若后面还有数，则看当前的与下一个谁更小
            if (minIndex + 1 < len && arr[minIndex] > arr[minIndex + 1]) minIndex++;
        }
        for (int i : arr) sum += i;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 6));
    }
}
