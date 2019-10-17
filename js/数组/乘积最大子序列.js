/**
 * @param {number[]} nums
 * @return {number}
 * @description 不知道为什么这个题目是动态规划
 */
var maxProduct = function (nums) {
    let maxCount = Number.MIN_VALUE,
        iMax = 1,
        iMin = 1;

    for (let i = 0, len = nums.length; i < len; i++) {
        if (nums[i] < 0) {
            let temp = iMax;
            iMax = iMin;
            iMin = temp;
        }
        iMax = Math.max(iMax * nums[i], nums[i]);
        iMin = Math.min(iMin * nums[i], nums[i]);
        maxCount = Math.max(iMax, maxCount);
        console.log(iMax, iMin, maxCount)
    }
    return maxCount;
};

console.log(maxProduct([-2]))