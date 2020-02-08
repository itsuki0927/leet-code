/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
var fourSum = function (nums, target) {
    let len = nums.length,
        list = [];
    if (nums == null || len < 4) return list;
    nums.sort((a, b) => (a - b));
    for (let i = 0; i < len - 3; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
        if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) continue;
        for (let j = i + 1; j < len - 2; j++) {
            if (j > i + 1 && nums[j] == nums[j - 1]) continue;
            if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
            if (nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) continue;
            let left = j + 1;
            let right = len - 1;
            while (left < right) {
                let sum = nums[i] + nums[j] + nums[left] + nums[right];
                if (sum == target) {
                    list.push([nums[i], nums[j], nums[left], nums[right]]);
                    while (left < right && nums[left] == nums[++left]);
                    while (left < right && nums[right] == nums[--right]);
                } else if (sum < target)
                    while (left < right && nums[left] == nums[++left]);
                else
                    while (left < right && nums[right] == nums[--right]);
            }
        }
    }
    return list
};

console.log(fourSum([0, 0, 0, 0], 0));