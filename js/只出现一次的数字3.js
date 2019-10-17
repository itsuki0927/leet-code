/**
 * @param {number[]} nums
 * @return {number[]}
 */
var singleNumber = function (nums) {
    let set = new Set();
    for (let i = 0, len = nums.length; i < len; i++) {
        let flag = set.has(nums[i]);
        if (flag) set.delete(nums[i]);
        else set.add(nums[i]);
    }
    return [...set];
};
var singleNumber2 = function (nums) {
    let obj = nums.reduce((acc, val) => {
        acc[val] = (acc[val] || 0) + 1;
        return acc;
    }, {});
    return Object.entries(obj).filter(([key, value]) => value == 1).map(([key]) => Number(key));
};

console.log(singleNumber([1, 2, 1, 3, 2, 5]));