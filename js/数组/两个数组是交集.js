/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersection = function (nums1, nums2) {
    const set1 = new Set([...nums1]);
    return [...new Set([...nums2.filter(v => set1.has(v))])];
};

console.log(intersection([1, 2, 2, 1], [2, 2]))