/**
 * @param {string} s
 * @return {string[][]}
 */
var partition = function (s) {
    let ans = [];
    let len = s.length;
    if (!len) return ans;

    function dp(list, index) {
        if (index == len) {
            ans.push([...list]);
            return;
        }
        for (let i = index; i < len; i++) {
            let str = s.substring(index, i + 1);
            if (isPartition(str)) {
                list.push(str);
                dp(list, i + 1);
                list.pop();
            }
        }
    }

    dp([], 0);

    return ans;
};

var isPartition = function (str) {
    for (let i = 0, len = str.length; i < len / 2; i++) {
        if (str[i] !== str[len - i - 1]) {
            return false;
        }
    }
    return true
}

console.log(partition('aab'));