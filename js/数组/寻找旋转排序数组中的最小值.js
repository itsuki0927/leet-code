/**
 * @param {number[]} nums
 * @return {number}
 * @description 找到第一个index > index+1 的num
 */
var findMin = function (nums) {
    for (let i = 0, len = nums.length - 1; i < len; i++) {
        if (nums[i] > nums[i + 1])
            return nums[i + 1];
    }
    return nums[0];
};
// var findMin = function (nums) {
//     let minNum = Number.MAX_VALUE;
//     for (let i = 0, len = nums.length; i < len; i++) {
//         if (nums[i] < minNum) {
//             minNum = nums[i];
//         }
//     }
//     return minNum;
// };

console.log(findMin([4, 5, 6, 7, 1, 2]))