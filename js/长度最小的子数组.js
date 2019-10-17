/**
 * @param {number} s
 * @param {number[]} nums
 * @return {number}
 */
var minSubArrayLen = function (s, nums) {
    let ans = Number.MAX_VALUE;
    let i = 0; //滑窗的右边框
    let sum = 0; //窗口间的和
    let begin = 0; //滑窗的左边框
    while (i < nums.length) //滑窗的右边框不能超出界限
    {
        //若滑窗之间的和小于s，右边框右移，sum增大
        if (sum + nums[i] < s) {
            sum += nums[i];
            ++i;
        }
        //若滑窗之间的和大于等于s，左边框右移，sum减小
        else {
            if (i - begin < ans) //若当前符合条件的连续子数组比ans内记录的长度更小，则更新ans值
                ans = i - begin + 1;
            sum = sum - nums[begin];
            ++begin;
        }
    }
    return ans == Number.MAX_VALUE ? 0 : ans;

};

// let ans = Number.MAX_VALUE;
// let i = 0; //滑窗的右边框
// let sum = 0; //窗口间的和
// let begin = 0; //滑窗的左边框
// while (i < nums.length) //滑窗的右边框不能超出界限
// {
//     //若滑窗之间的和小于s，右边框右移，sum增大
//     if (sum + nums[i] < s) {
//         sum += nums[i];
//         ++i;
//     }
//     //若滑窗之间的和大于等于s，左边框右移，sum减小
//     else {
//         if (i - begin < ans) //若当前符合条件的连续子数组比ans内记录的长度更小，则更新ans值
//             ans = i - begin + 1;
//         sum = sum - nums[begin];
//         ++begin;
//     }
// }
// return ans == Number.MAX_VALUE ? 0 : ans;

console.log(minSubArrayLen(11, [1, 2, 3, 4, 5]));