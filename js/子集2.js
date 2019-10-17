/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function (nums) {
    let list = [];
    nums.sort();
    getAns(nums, 0, [], list);
    return list;
};

var getAns = function (nums, start, temp, ans) {
    ans.push([...temp]);
    for (let i = start; i < nums.length; i++) {
        //和上个数字相等就跳过
        if (i > start && nums[i] == nums[i - 1]) {
            continue;
        }

        temp.push(nums[i]);
        getAns(nums, i + 1, temp, ans);
        temp.pop();
    }
}

console.log(subsetsWithDup([4, 4, 4, 1, 4]));

console.log([
    [],
    [1],
    [1, 4],
    [1, 4, 4],
    [1, 4, 4, 4],
    [1, 4, 4, 4, 4],
    [4],
    [4, 4],
    [4, 4, 4],
    [4, 4, 4, 4]
]);