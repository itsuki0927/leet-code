/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function (nums) {
    let len = nums.length;
    if (!len) return 0;
    let list = Array(len).fill(1);
    for (let i = 1; i < len; i++) {
        let curVal = nums[i];
        for (let j = 0; j < i; j++) {
            if (curVal > nums[j]) {
                list[i] = Math.max(list[j] + 1, list[i]);
            }
        }
    }
    let res = list[0];
    for (let i = 0; i < len; i++) {
        res = Math.max(res, list[i]);
    }
    return res;
};

lengthOfLIS([10, 9, 2, 5, 3, 7, 101, 18])