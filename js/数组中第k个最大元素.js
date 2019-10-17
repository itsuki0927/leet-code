/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function (nums, k) {
    return partition(nums, nums.length - k, 0, nums.length - 1);
};


function partition(nums, k, s, e) {
    let i = s;
    let j = e;
    let flag = nums[s];
    while (i < j) {
        while (i < j && nums[j] >= flag) {
            j--;
        }
        swap(nums, i, j);
        while (i < j && nums[i] <= flag) {
            i++;
        }
        swap(nums, i, j);
    }
    if (i == k) return flag;
    else if (i > k) return partition(nums, k, s, i - 1);
    else return partition(nums, k, i + 1, e);
}

var swap = function (N, i, j) {
    let tmp = N[i];
    N[i] = N[j];
    N[j] = tmp;
}

console.log(findKthLargest([3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6], 2));