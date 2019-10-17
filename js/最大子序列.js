/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function (nums) {
    let ans = nums[0],
        count = 0;
    for (let i = 0, len = nums.length; i < len; i++) {
        if (count > 0) {
            count += nums[i];
        } else {
            count = nums[i];
        }
        ans = Math.max(ans, count);
    }
    return ans;
};

console.log(maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]));