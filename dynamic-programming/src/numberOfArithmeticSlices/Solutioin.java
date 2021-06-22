package numberOfArithmeticSlices;

/**
 * @author: itsuki
 * @create: 2021-06-22 14:58
 **/
public class Solutioin {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        int[] dp = new int[nums.length + 1];
        int sum = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solutioin().numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }
}
