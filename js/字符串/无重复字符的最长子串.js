/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
    let left = 0,
        right = 0,
        length = 0,
        result = 0;
    while (right < s.length) {
        const index = s.indexOf(s[right], left);
        if (index < right) {
            if (length > result) {
                result = length;
            }
            if (result >= s.length - index - 1) {
                return result;
            }
            length = right - index - 1;
            left = index + 1;
        }

        length++;
        right++;
    }
    return length;
};

console.log(lengthOfLongestSubstring('abcabcbb'));