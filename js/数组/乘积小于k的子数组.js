/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 * @description
 * 双指针法，如果一个子串的乘积小于k，那么他的每个子集都小于k，
 * 而一个长度为n的数组，他的所有连续子串数量是1+2+...n，但是会和前面的重复。
 * 比如例子中[10, 5, 2, 6]，第一个满足条件的子串是[10]，第二个满足的是[10, 5]，
 * 但是第二个数组的子集[10]和前面的已经重复了，因此我们只需要计算包含最右边的数字的子串数量，就不会重复了，
 * 也就是在计算[10, 5]这个数组的子串是，只加入[5]和[10, 5]，而不加入[10]，这部分的子串数量刚好是r - l + 1
 */
var numSubarrayProductLessThanK = function (nums, k) {
    if (k == 0 || k == 1) return 0;
    let l = 0,
        prod = 1,
        count = 0;
    for (let r = 0, len = nums.length; r < len; r++) {
        prod *= nums[r];
        while (prod >= k) {
            prod /= nums[l++]; // 计算右侧的值 防止重复
        }
        count += (r - l) + 1;
    }
    return count;
};

console.log(numSubarrayProductLessThanK([10, 5, 2, 6], 100));