/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function (s) {
    console.log(s.split(' ').map(v => v.trim()));

    return s.split(' ').filter(Boolean).reverse().join(' ')
};

console.log(reverseWords("  hello world!  "))