package largestSumAfterKNegations;

/**
 * 解题思路: 按照绝对值逆序, 然后转变大的负数, 进行相对应的累加
 *
 * @author: itsuki
 * @create: 2021-04-27 09:17
 **/
public class Solution {
    private static void swap(int[] arr, int i, int j) {
        int n = arr[i];
        arr[i] = arr[j];
        arr[j] = n;
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1, more = r, pivot = Math.abs(arr[r]);
        while (l < more) {
            if (Math.abs(arr[l]) < pivot) {
                swap(arr, l, --more);
            } else if (Math.abs(arr[l]) > pivot) {
                swap(arr, l++, ++less);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, (int) (l + Math.floor(Math.random() * (r - l + 1))), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int largestSumAfterKNegations(int[] A, int K) {
        int n = A.length;
        // 快排逆序
        quickSort(A, 0, n - 1);
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] < 0 && K > 0) {
                A[i] *= -1;
                K--;
            }
            // 最后一个要做处理, k > 0的时候还得进行变换
            if (i != n - 1) {
                ret += A[i];
            }
        }
        // k > 0 <==> k % 2次, 所以只需要变换一次即可
        if (K % 2 == 1) {
            A[n - 1] *= -1;
        }
        // 添加最后的值
        ret += A[n - 1];
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 6));
    }
}
