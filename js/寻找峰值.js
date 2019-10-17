/**
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement1 = function (nums) {
    let len = nums.length - 1;
    for (let i = 0; i < len; i++) {
        if (nums[i] > nums[i + 1])
            return i;
    }
    return len;
};
var findPeakElement2 = function (nums) {
    let l = 0,
        r = nums.length - 1;
    while (l < r) {
        let mid = Math.floor((l + r) / 2);
        if (nums[mid] > nums[mid + 1])
            r = mid;
        else
            l = mid + 1;
    }
    return l;
};

var findPeakElement3 = function (nums) {
    return search(nums, 0, nums.length - 1);
}

function search(nums, l, r) {
    if (l == r)
        return l;
    let mid = Math.floor((l + r) / 2);
    if (nums[mid] > nums[mid + 1])
        return search(nums, l, mid);
    return search(nums, mid + 1, r);
}

console.log(findPeakElement([1, 2, 1, 3, 5, 6, 4]));