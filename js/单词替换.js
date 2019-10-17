/**
 * @param {string[]} dict
 * @param {string} sentence
 * @return {string}
 */
var replaceWords = function (dict, sentence) {
    let list = sentence.split(' ');
    return list.map(v => {
        for (let i = 0, len = dict.length; i < len; i++) {
            if (v.startsWith(dict[i])) return dict[i];
        }
        return v;
    }).join(' ')
};

console.log(replaceWords(["cat", "bat", "rat"], "the cattle was rattled by the battery"));