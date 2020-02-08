/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function (n) {
    var list = [];

    generate('', 0, 0)

    function generate(str, l, r) {
        if (l > n || r > n) return;
        if (l === n && r == n) {
            list.push(str)
            return;
        }
        if (l < n) {
            generate(str + "(", l + 1, r);
        }
        if (r < l) {
            generate(str + ")", l, r + 1);
        }
    }
    console.log(list);

    return list;
};

generateParenthesis(3)