package findPeakElement;

/**
 * @author: itsuki
 * @create: 2021-05-12 09:14
 **/
public class Solution {
    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // 如果左侧 > 左侧的右边那个数, 表示左侧一定有峰值
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 1}));
    }
}
