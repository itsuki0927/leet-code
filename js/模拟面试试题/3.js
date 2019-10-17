/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function (n) {
    console.log(n);
    console.log(String(n).split('').reverse().join(''));

    return parseInt(String(n).split('').reverse().join(''));
};

console.log(reverseBits(00000010100101000001111010011100));