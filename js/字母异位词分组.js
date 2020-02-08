/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function (strs) {

    let hashMap = new Map()

    strs.forEach(el => {
        let str = el.split('').sort().join()
        if (hashMap.has(str)) {
            let temp = hashMap.get(str)
            temp.push(el)
            hashMap.set(str, temp)
        } else {
            hashMap.set(str, [el])
        }
    })

    return [...hashMap.values()]
};

let l = groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"])

console.log(l);