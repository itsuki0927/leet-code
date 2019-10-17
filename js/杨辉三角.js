/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function (numRows) {
    if (numRows == 1) return [
        [1]
    ]
    if (numRows == 2) return [
        [1],
        [1, 1]
    ]
    let list = Array.from({
        length: numRows
    }, (v, i) => Array(i + 1).fill(0))
    for (let i = 0; i < numRows; i++) list[i][0] = 1;
    for (let i = 1; i < numRows; i++) list[i][i] = 1;
    for (let i = 2; i < numRows; i++) {
        for (let j = 1; j < i; j++) {
            list[i][j] = list[i - 1][j - 1] + list[i - 1][j]
        }
    }
    return list;
};

console.log(generate(5));