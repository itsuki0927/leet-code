/**
 * @param {string[]} letters
 * @param {string} target
 * @return {string}
 */
var nextGreatestLetter = function (letters, target) {
    let len = letters.length;
    let l = 0,
        r = len - 1;
    while (l <= r) {
        let mid = Math.floor((l + r) / 2);
        if (target < letters[mid])
            r = mid - 1;
        else
            l = mid + 1;
    }
    return letters[l % len];
};

console.log(nextGreatestLetter(["c", "f", "j"], "d"))