/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function (height) {
    let area = 0,
        left = 0,
        right = height.length - 1;
    while (left < right) {
        area = Math.max(area, (right - left) * Math.min(height[left], height[right]));
        if (height[left] < height[right]) {
            left++;
        } else right--;
    }
    return area;
};

console.log(maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]));