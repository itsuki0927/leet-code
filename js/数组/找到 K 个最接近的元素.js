/**
 * @param {number[]} arr
 * @param {number} k
 * @param {number} x
 * @return {number[]}
 */
var findClosestElements = function (arr, k, x) {
    let left = 0,
        right = arr.length - 1;
    while (left < right) {
        let mid = Math.floor((left + right) / 2);
        if (x - arr[mid] > arr[mid + k] - x) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return arr.slice(left, left + k);
};
// 双指针删除
var findClosestElements2 = function (arr, k, x) {
    let left = 0,
        right = arr.length - 1,
        removeNum = right - k + 1;
    while (removeNum--) {
        if (x - arr[left] <= arr[right] - x) {
            right -= 1;
        } else left += 1;
    }
    return arr.slice(left, left + k);
};

console.log(findClosestElements([1, 2, 3, 4, 5], 4, 3))