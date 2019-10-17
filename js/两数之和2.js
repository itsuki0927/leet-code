/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 * @description 使用双指针
 */
var twoSum = function (numbers, target) {
    let left = 0,
        right = numbers.length;
    while (left < right) {
        if (numbers[left] + numbers[right] == target) {
            return [left + 1, right + 1];
        } else if (numbers[left] + numbers[right] < target) {
            left++;
        } else right--;
    }
};

console.log(twoSum([-1, 0], -1))