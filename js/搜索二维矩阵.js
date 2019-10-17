/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function (matrix, target) {
    if (matrix.length <= 0) return false;
    let len = matrix.length;
    let m = matrix[0].length;
    let index = 0;
    for (let i = 0; i < len; i++) {
        if (matrix[i][m - 1] >= target) {
            index = i;
            break;
        }
    }
    return matrix[index].includes(target);
};

console.log(searchMatrix([
    [1, 4, 7, 11, 15],
    [2, 5, 8, 12, 19],
    [3, 6, 9, 16, 22],
    [10, 13, 14, 17, 24],
    [18, 21, 23, 26, 30]
], 5));