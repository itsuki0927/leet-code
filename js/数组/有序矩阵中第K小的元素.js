/**
 * @param {number[][]} matrix
 * @param {number} k
 * @return {number}
 * @description 二分法
 */
var kthSmallest = function (matrix, k) {
    let row = matrix.length,
        col = matrix[0].length - 1,
        left = matrix[0][0],
        right = matrix[row - 1][row - 1];

    while (left < right) {
        let mid = Math.floor((right + left) / 2);
        let count = 0,
            j = col;
        for (let i = 0; i < row; i++) {
            while (j >= 0 && matrix[i][j] > mid) j--;
            count += j + 1;
        }
        if (count < k) {
            left = mid + 1;
        } else right = mid;
    }
    return left
}

// var kthSmallest = function (matrix, k) {
//     let row = matrix.length;
//     let col = matrix[0].length;
//     let left = matrix[0][0];
//     let right = matrix[row - 1][col - 1];
//     while (left < right) {
//         // 每次循环都保证第K小的数在start~end之间，当start==end，第k小的数就是start
//         let mid = Math.floor((left + right) / 2);
//         // 找二维矩阵中<=mid的元素总个数
//         let count = findNotBiggerThanMid(matrix, mid, row, col);
//         console.log(`${left}-${right}, mid:${mid}, count:$${count}`)
//         if (count < k) {
//             // 第k小的数在右半部分，且不包含mid
//             left = mid + 1;
//         } else {
//             // 第k小的数在左半部分，可能包含mid
//             right = mid;
//         }
//     }
//     return right;
// }

// var findNotBiggerThanMid = function (matrix, mid, row, col) {
//     // 以列为单位找，找到每一列最后一个<=mid的数即知道每一列有多少个数<=mid
//     let i = row - 1;
//     let j = 0;
//     let count = 0;
//     console.log('--------------')
//     while (i >= 0 && j < col) {
//         if (matrix[i][j] <= mid) {
//             console.log(matrix[i][j])
//             // 第j列有i+1个元素<=mid
//             count += i + 1;
//             j++;
//         } else {
//             // 第j列目前的数大于mid，需要继续在当前列往上找
//             i--;
//         }
//     }
//     console.log('--------------')
//     return count;
// }
console.log(kthSmallest([
    [1, 5, 7],
    [10, 11, 13],
    [12, 13, 15]
], 8))