package fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: itsuki
 * @create: 2021-06-03 09:05
 **/
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        if (length < 4) return result;

        for (int i = 0; i < length - 3; i++) {
            //去重1：起点是0，当i==i-1时，说明i-1已经计算过，跳过i
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //剪枝1：以当前i为起点的最左边四个元素（降序）总和都比target大时，后续的遍历更大，直接break
            int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min > target)
                break;

            //剪枝2：以当前i为起点的元素+最右边三个元素之和都比target小时，以i为起点的遍历不可能比target大，跳过i
            int max = nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max < target)
                continue;
            for (int j = i + 1; j < length - 2; j++) {
                //去重2：起点是i+1，当j==j-1时，说明i-1已经计算过，跳过i
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                //剪枝3：同剪枝1思想，只是起点是第二个元素即j
                min = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (min > target)
                    break;

                //剪枝4：同剪枝2思想，只是起点是第二个元素即j
                max = nums[i] + nums[j] + nums[length - 1] + nums[length - 2];
                if (max < target)
                    continue;
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        //去重3：当四个元素的左第三个元素存在重复，跳过
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        //去重4：当四个元素的左第四个元素存在重复，跳过
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().fourSum(new int[]{-1, 0, 1, 2, -1, -4}, -1);
        lists.forEach(System.out::println);
    }
}
