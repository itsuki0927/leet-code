/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function (matrix, target) {
    if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;
    //起点为最右上角的元素
    let row = 0,
        col = matrix[0].length - 1;

    //判断当前数组元素和target，如果当前大于target，往左走；小与target，往下走
    while (row < matrix.length && col >= 0) {

        if (target > matrix[row][col]) {
            row++;
        } else if (target < matrix[row][col]) {
            col--;
        } else {
            return true;
        }
    }
    return false;
};

console.log([
    [1, 4, 7, 11, 15],
    [2, 5, 8, 12, 19],
    [3, 6, 9, 16, 22],
    [10, 13, 14, 17, 24],
    [18, 21, 23, 26, 30]
], 5)