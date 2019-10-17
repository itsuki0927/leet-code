/**
 * 
 * @param {number[]} nums1 
 * @param {number[]} nums2 
 */
function jiaoji(nums1, nums2) {
    return nums1.filter(v => !!~nums2.indexOf(v))
}

console.log(jiaoji([1, 2, 2, 1], [2]));