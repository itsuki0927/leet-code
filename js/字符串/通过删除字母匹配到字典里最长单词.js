/**
 * @param {string} s
 * @param {string[]} d
 * @return {string}
 */
var findLongestWord = function (s, d) {
    let max = Number.MIN_VALUE;
    let maxIndex = -1;
    const length = s.length;

    for (let i = 0, len = d.length; i < len; i++) {
        const str = d[i];
        if (isContain(str)) {
            if (str.length > max || (str.length == max && str < d[maxIndex])) {
                max = str.length;
                maxIndex = i;
            }
        }
    }

    function isContain(str) {
        let j = 0;
        for (let i = 0; i < length; i++) {
            if (s[i] == str[j]) j++;
        }
        return j == str.length;
    }
    return maxIndex == -1 ? '' : d[maxIndex];
};

console.log(findLongestWord('abpcplea', ["ale", "apple", "monkey", "plea"]))