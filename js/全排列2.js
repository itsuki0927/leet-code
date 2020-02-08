/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function (nums) {
    let list = [];
    nums.sort();
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
        //i-1和i的值相等，且i-1没被用过（之后可能会被用就产生重复）
        if (i > 0 && nums[i] === nums[i - 1] && !flagList[i - 1]) continue;
        if (!flagList[i]) {
            temp.push(nums[i]);
            flagList[i] = 1;
            dp(nums, ans, temp, flagList);
            flagList[i] = 0;
            temp.pop();
        }
    }
}

console.log(permuteUnique([3, 3, 0, 3]));