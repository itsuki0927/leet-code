/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
var findAnagrams = function (s, p) {
    let list = [],
        findLen = p.length,
        totalLen = s.length,
        map = new Map(),
        sortP = sort(p);
    for (let i = 0; i <= totalLen - findLen; i++) {
        if (p.includes(s[i])) {
            let str = s.substr(i, findLen);
            // console.log(i, sort(str), sortP, sort(str) == sortP);
            if (map.has(str) || sort(str) == sortP) {
                map.set(str, true);
                list.push(i);
            }
        }
    }

    function sort(str) {
        return str.split('').sort().join('')
    }
    return list;
};

console.log(findAnagrams("abab", "ab"));