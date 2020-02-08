/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function (s) {
    let list = s.split(' ').filter(Boolean);
    return list.length && list.pop().length
};

console.log(lengthOfLastWord("  "));