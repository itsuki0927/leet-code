/**
 * @param {number} n
 * @return {number[][]}
 */
var generateMatrix1 = function (n) {
    if (!n) return [
        []
    ];
    if (n == 1) return [
        [1]
    ]
    let up = 0,
        right = n - 1,
        down = n - 1,
        left = 0;
    let i = 1;
    let list = Array.from({
        length: n
    }).map(() => Array.from({
        length: n
    }));
    while (true) {
        for (let j = left; j <= right; j++, i++) list[up][j] = i;
        if (++up > down) break;
        for (let j = up; j <= down; j++, i++) list[j][right] = i;
        if (--right < left) break;
        for (let j = right; j >= left; j--, i++) list[down][j] = i;
        if (--down < up) break;
        for (let j = down; j >= up; j--, i++) list[j][left] = i;
        if (++left > right) break;
    }
    return list
};
var generateMatrix2 = function (n) {
    let list = Array.from({
        length: n
    }).map(() => Array.from({
        length: n
    }));
    let c = 1,
        j = 0;
    while (c <= n * n) {

        for (let i = j; i < n - j; i++)
            list[j][i] = c++;
        for (let i = j + 1; i < n - j; i++)
            list[i][n - j - 1] = c++;
        for (let i = n - j - 2; i >= j; i--)
            list[n - j - 1][i] = c++;
        for (let i = n - j - 2; i > j; i--)
            list[i][j] = c++;

        j++;
    }

    return list;
};

console.log(generateMatrix1(9));