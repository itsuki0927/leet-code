var longestPalindrome = function (s) {
    let max = "";
    let les = 0;
    for (let i = 0; i < s.length; i++) {
        for (let j = i + 1; j < s.length; j++) {
            let str = s.slice(i, j + 1);
            if (judge(str) && str.length > les) {
                les = Math.max(les, str.length)
                max = str;
            }
        }
    }
    console.log(max);
    return max;
};

var judge = function (str) {
    let len = str.length;
    for (let i = 0; i < len / 2; i++) {
        if (str[i] != str[len - i - 1]) {
            return false;
        }
    }
    return true;
}

longestPalindrome("aaabaaaa")