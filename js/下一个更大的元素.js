/**
 * @param {number[]} nums
 * @return {number[]}
 */
var nextGreaterElements = function (nums) {
    let list = [],
        len = nums.length;
    for (let i = 0; i < len; i++) {
        list.push(dp(i, nums[i]))
    }

    function dp(index, num) {
        for (++index; index < len; index++) {
            if (nums[index] > num) return nums[index];
        }
        for (let i = 0; i < index; i++) {
            if (nums[i] > num) return nums[i];
        }
        return -1
    }
    return list
};

console.log(nextGreaterElements([1, 2, 1]));