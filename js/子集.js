/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function (nums) {
    let list = [];
    getAns(nums, 0, [], list);
    return list;
};

function getAns(nums, start, temp, ans) {
    ans.push([...temp]);
    for (let i = start; i < nums.length; i++) {
        temp.push(nums[i]);
        getAns(nums, i + 1, temp, ans);
        temp.pop();
    }
}



console.log(subsets([1, 2, 3]));