/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function (nums) {
    let len = nums.length,
        k = 1,
        res = Array(len);
    for (let i = 0; i < len; i++) {
        res[i] = k;
        k = k * nums[i]; // 此时数组存储的是除去当前元素左边的元素乘积
    }
    k = 1;
    for (let i = len - 1; i >= 0; i--) {
        res[i] *= k; // k为该数右边的乘积。
        k *= nums[i]; // 此时数组等于左边的 * 该数右边的。
    }
    return res;
};

console.log(productExceptSelf([1, 2, 3, 4]));