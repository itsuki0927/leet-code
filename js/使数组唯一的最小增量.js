/**
 * @param {number[]} A
 * @return {number}
 * @description 明天看懂这里
 */
var minIncrementForUnique = function (A) {
    let n = Array(50000).fill(0);
    let len = A.length;
    for (let i = 0; i < len; i++) n[A[i]]++;

    let move = 0;
    for (let i = 0; i < 50000; i++) {
        if (n[i] <= 1) continue;

        move += n[i] - 1; // 
        n[i + 1] += n[i] - 1;
        n[i] = 1;
    }
    return move;
};
var minIncrementForUnique2 = function (A) {
    let len = A.length;
    if (len <= 1) return 0;
    let minCount = 0;
    A.sort((a, b) => a - b);
    for (let i = 1; i < len; i++) {
        if (A[i] <= A[i - 1]) {
            let t = A[i];
            A[i] = A[i - 1] + 1;
            minCount += A[i] - t
        }
    }
    return minCount;
};

console.log(minIncrementForUnique([3, 2, 1, 2, 1, 7]));