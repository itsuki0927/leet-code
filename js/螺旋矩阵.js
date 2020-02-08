/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var spiralOrder1 = function (matrix) {
    let up = 0,
        down = matrix.length - 1,
        right = (matrix[0] || []).length - 1,
        left = 0;
    if (!~right || !~down) return [];
    let list = [];
    while (true) {
        for (let i = left; i <= right; i++) list.push(matrix[up][i]);
        if (++up > down) break;
        for (let i = up; i <= down; i++) list.push(matrix[i][right]);
        if (--right < left) break;
        for (let i = right; i >= left; i--) list.push(matrix[down][i]);
        if (--down < up) break;
        for (let i = down; i >= up; i--) list.push(matrix[i][left]);
        if (++left > right) break;
    }
    return list;
};
var spiralOrder2 = function (matrix) {
    if (!matrix.length || !matrix[0].length) return [];
    let res = [];
    let rowLen = matrix.length,
        colLen = matrix[0].length;
    // 确定上下左右四条边的位置
    let up = 0,
        down = rowLen - 1,
        left = 0,
        right = colLen - 1;
    while (true) {
        for (let i = left; i <= right; i++) res.push(matrix[up][i]);
        if (++up > down) {
            break;
        }
        for (let i = up; i <= down; i++) res.push(matrix[i][right]);
        if (--right < left) {
            break;
        };
        for (let i = right; i >= left; i--) res.push(matrix[down][i]);
        if (--down < up) {
            break;
        };
        for (let i = down; i >= up; i--) res.push(matrix[i][left]);
        if (++left > right) {
            break;
        };
    }
    return res;
};
console.log(spiralOrder([]));