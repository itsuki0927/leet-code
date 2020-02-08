/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 * @description BT 后面再学思路
 */
var findMedianSortedArrays = function (nums1, nums2) {
    let m = nums1.length;
    let n = nums2.length;
    if (m > n) {
        return findMedianSortedArrays(nums2, nums1); // 保证 m <= n
    }
    let iMin = 0,
        iMax = m;
    while (iMin <= iMax) {
        let i = ((iMin + iMax) / 2) | 0;
        let j = (((m + n + 1) / 2) | 0) - i;
        if (j != 0 && i != m && nums2[j - 1] > nums1[i]) { // i 需要增大
            iMin = i + 1;
        } else if (i != 0 && j != n && nums1[i - 1] > nums2[j]) { // i 需要减小
            iMax = i - 1;
        } else { // 达到要求，并且将边界条件列出来单独考虑
            let maxLeft = 0;
            if (i == 0) {
                maxLeft = nums2[j - 1];
            } else if (j == 0) {
                maxLeft = nums1[i - 1];
            } else {
                maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
            }
            if ((m + n) % 2 == 1) {
                return maxLeft;
            } // 奇数的话不需要考虑右半部分

            let minRight = 0;
            if (i == m) {
                minRight = nums2[j];
            } else if (j == n) {
                minRight = nums1[i];
            } else {
                minRight = Math.min(nums2[j], nums1[i]);
            }

            return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
        }
    }
    return 0.0;
};

console.log(findMedianSortedArrays([1, 3], [2]));