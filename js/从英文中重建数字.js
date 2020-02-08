/**
 * 6.找z的个数判断zero  //
 * 3.找w的个数判断two  // 
 * 5.找h的个数判断three  //
 * 1.找u的个数判断four // 
 * 8,找x的个数判断six  // 
 * 4.找g的个数判断eight  //
 * 7.找o的个数判断one
 * 2.找f的个数判断five 
 * 9.找s的个数判断seven 
 * 10.找e的个数判断nine 
 */

/**
 * @param {string} s
 * @return {string}
 */
var originalDigits = function (s) {
    let word = {
        'o': 'one',
        'w': 'two',
        'h': 'three',
        'u': 'four',
        'f': 'five',
        'x': 'fix',
        's': 'seven',
        'g': 'eight',
        'e': 'nine'
    }
    let wordToDigits = {
        'o': 1,
        'w': 2,
        'h': 3,
        'u': 4,
        'f': 5,
        'x': 6,
        's': 7,
        'g': 8,
        'e': 9
    }

};

console.log(originalDigits('sevennine')); // 1  3