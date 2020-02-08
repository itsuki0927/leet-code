/**
 * @param {number} n
 * @return {number}
 */
var nthUglyNumber = function (n) {
    let result = [1];
    let r2 = 0, r3 = 0, r5 = 0, min;
    while (result.length < n) {
        min = Math.min(result[r2] * 2, result[r3] * 3, result[r5] * 5);

        if (min == result[r2] * 2) {
            r2++;
        }
        if (min == result[r3] * 3) {
            r3++;
        }
        if (min == result[r5] * 5) {
            r5++;
        }
        result.push(min);
    }
    return result[n - 1];
};

console.log(nthUglyNumber(10))