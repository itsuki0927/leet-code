/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function (digits) {
    if (digits.length < 1) return []
    var dict = {
        2: ['a', 'b', 'c'],
        3: ['d', 'e', 'f'],
        4: ['g', 'h', 'i'],
        5: ['j', 'k', 'l'],
        6: ['m', 'n', 'o'],
        7: ['p', 'q', 'r', 's'],
        8: ['t', 'u', 'v'],
        9: ['w', 'x', 'y', 'z'],
    }
    let list = digits.split('').map(item => dict[item])
    var re = list.reduce((a, b, i) => {
        let temp = []
        a.forEach(ai => {
            b.forEach(bi => {
                temp.push(ai + bi)
            })
        })
        return temp
    })
    return re
};

var letterCombinations2 = function (digits) {
    let dict = [
        0, 0, ["a", "b", "c"],
        ["d", "e", "f"],
        ["g", "h", "i"],
        ["j", "k", "l"],
        ["m", "n", "o"],
        ["p", "q", "r", "s"],
        ["t", "u", "v"],
        ["w", "x", "y", "z"]
    ]
    return digits.length ? digits.split("").map(i => dict[i]).reduce((a, b) =>
        //遍历所有数组的组合
        a.map(x => b.map(y => x + y)).join(",").split(",")
    ) : [];
};

var letterCombinations = function (digits) {
    const dict = {
        2: ['a', 'b', 'c'],
        3: ['d', 'e', 'f'],
        4: ['g', 'h', 'i'],
        5: ['j', 'k', 'l'],
        6: ['m', 'n', 'o'],
        7: ['p', 'q', 'r', 's'],
        8: ['t', 'u', 'v'],
        9: ['w', 'x', 'y', 'z'],
    };

    return render(digits);

    function render(str) {
        let arr = [];
        if (str.length === 0) {
            arr = [];
        } else if (str.length === 1) {
            arr = dict[str];
        } else {
            dict[str[0]].forEach(char => {
                render(str.slice(1)).forEach(nstr => {
                    arr.push(char + nstr);
                });
            });
        }
        return arr;
    }
};



letterCombinations2("234")