/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 * @description 没懂为啥要这么写
 */
var myPow = function (x, n) {
    let res = 1;
    for (let i = n; i != 0; i = ((i / 2) | 0)) {
        if (i % 2 != 0) {
            res *= x;
        }
        x *= x;
    }
    return n < 0 ? 1 / res : res;
};
console.log(myPow(2.00000, -2));


// 
var myPow2 = function (x, n) {
    return x ** n;
};