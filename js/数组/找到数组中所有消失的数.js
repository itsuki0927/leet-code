/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDisappearedNumbers = function (nums) {
    if (nums.length == 0) return [];
    let list = [];
    for (let i = 0, len = nums.length; i < len; i++) {
        let num = nums[Math.abs(nums[i]) - 1];
        if (num > 0)
            nums[Math.abs(nums[i]) - 1] = -num;
    }
    for (let i = 0, len = nums.length; i < len; i++) {
        if (nums[i] > 0) list.push(i + 1);
    }
    return list;
};

console.log(findDisappearedNumbers([4, 3, 2, 7, 8, 2, 3, 1]))