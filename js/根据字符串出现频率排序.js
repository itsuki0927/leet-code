/**
 * @param {string} s
 * @return {string}
 */
var frequencySort = function (s) {
    let obj = s.split('').reduce((acc, val) => ((acc[val] = (acc[val] || '') + val) && acc), {})
    return Object.values(obj).sort((a, b) => (b.length - a.length)).join('');
};

console.log(frequencySort('Aabb'));