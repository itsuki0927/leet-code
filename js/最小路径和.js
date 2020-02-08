/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function (grid) {
    let dp = Array.from({
        length: grid[0].length
    }).fill(0);
    for (let i = grid.length - 1; i >= 0; i--) {
        for (let j = grid[0].length - 1; j >= 0; j--) {
            if (i == grid.length - 1 && j != grid[0].length - 1)
                dp[j] = grid[i][j] + dp[j + 1];
            else if (j == grid[0].length - 1 && i != grid.length - 1)
                dp[j] = grid[i][j] + dp[j];
            else if (j != grid[0].length - 1 && i != grid.length - 1)
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
            else
                dp[j] = grid[i][j];
        }
    }
    return dp[0];
};

var minPathSum2 = function (grid) {
    if (grid == null || grid.length < 1 || grid[0] == null || grid[0].length < 1) {
        return 0;
    }

    let row = grid.length;
    let col = grid[row - 1].length;

    let dp = Array.from({
        length: row
    }).map(() => Array.from({
        length: col
    }));

    dp[0][0] = grid[0][0];

    for (let i = 1; i < row; i++) {
        dp[i][0] = dp[i - 1][0] + grid[i][0];
    }

    for (let i = 1; i < col; i++) {
        dp[0][i] = dp[0][i - 1] + grid[0][i];
    }

    for (let i = 1; i < row; i++) {
        for (let j = 1; j < col; j++) {
            dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
        }
    }

    return dp[row - 1][col - 1];
};


console.log(minPathSum([
    [1, 3, 1],
    [1, 5, 1],
    [4, 2, 1]
]));