/**
 * @param {string[]} A
 * @return {string[]}
 */
var commonChars = function (A) {
    let list = [];
    A = A.map(v => v.split('').sort());

    A.sort((a, b) => (a.length - b.length));
    for (let i = 0, len = A[0].length; i < len;) {
        let el = A[0][i];
        let flag = true;
        for (let j = 1; j < A.length; j++) {
            if (!A[j].includes(el)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            list.push(el);
            A.forEach(item => {
                item.splice(item.indexOf(el), 1)
            })
        } else {
            i++
        }
    }
    return list;
};

commonChars(["cool", "lock", "cook"])