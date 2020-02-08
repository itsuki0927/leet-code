/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function (nums1, m, nums2, n) {

    let list = nums1.slice(0, m).concat(nums2.slice(0, n));
    nums1.length = 0;
    nums1.push(...list);
    nums1.sort();
};

console.log(merge([1, 2, 3, 0, 0, 0], 3, [2, 5, 6], 3));