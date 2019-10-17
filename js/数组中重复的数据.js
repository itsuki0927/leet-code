/**
 * @param {number[]} nums
 * @return {number[]}
 * @description 思路就是将出现过的数字至于负数 再次出现则是正数 也就是重复的数字
 */
var findDuplicates = function (nums) {
    let list = [];
    for (let i = 0; i < nums.length; ++i) {
        let index = Math.abs(nums[i]) - 1;
        nums[index] = -nums[index];
        if (nums[index] > 0) {
            list.push(index + 1);
        }
    }
    return list;
};


console.log(findDuplicates([4, 3, 2, 7, 8, 2, 3, 1])); // 3 2 1 6 7 1 2 0