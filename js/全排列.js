/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function (nums) {
    let list = [];
    let flagList = Array({
        length: nums.length
    }).fill(0);
    dp(nums, list, [], flagList);
    return list;
};

var dp = function (nums, ans, temp, flagList) {
    let len = nums.length;
    if (temp.length === len) {
        ans.push([...temp]);
        return;
    }
    for (let i = 0; i < len; i++) {
        if (!flagList[i]) {
            temp.push(nums[i]);
            flagList[i] = 1;
            dp(nums, ans, temp, flagList);
            flagList[i] = 0;
            temp.pop();
        }
    }
}

console.log(permute([1, 2, 3, 4]));