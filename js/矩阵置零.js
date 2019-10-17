/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function (matrix) {
    let ROW = matrix.length;
    let COL = matrix[0].length;
    let rowSet = new Set();
    let colSet = new Set();

    for (let i = 0; i < ROW; i++) {
        for (let j = 0; j < COL; j++) {
            if (!matrix[i][j]) {
                rowSet.add(i);
                colSet.add(j);
            }
        }
    }
    for (let i = 0; i < ROW; i++) {
        for (let j = 0; j < COL; j++) {
            if (rowSet.has(i) || colSet.has(j)) {
                matrix[i][j] = 0;
            }
        }
    }
};


console.log(setZeroes([
    [0, 1, 2, 0],
    [3, 4, 5, 2],
    [1, 3, 1, 5]
]));