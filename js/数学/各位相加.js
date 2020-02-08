/**
 * @param {number} num
 * @return {number}
 * @description
 * 除了传统的单纯循环，还可以找规律。
 * 假如一个三位数'abc'，其值大小为s1 = 100 * a + 10 * b + 1 * c，经过一次各位相加后，
 * 变为s2 = a + b + c，减小的差值为(s1 -s2) = 99 * a + 9 * b，差值可以被9整除，
 * 每一个循环都这样，缩小了9的倍数。当num小于9，即只有一位时，直接返回num，
 * 大于9时，如果能被9整除，则返回9（因为不可能返回0也不可能返回两位数及以上的值），
 * 如果不能被整除，就返回被9除的余数。
 */
var addDigits = function (num) {
    if (num < 10) {
        return num;
    }
    const res = num % 9;
    if (res == 0) {
        return 9;
    }
    return res;
};

console.log(addDigits(38))