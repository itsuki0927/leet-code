/**
 * @param {number[]} nums
 * @param {number} S
 * @return {number}
 * 
 * sum(P) +的集合 sum(N) -的集合
 * sum(P) - sum(N) = target =>
 * sum(P) - sum(N) + sum(P) + sum(N) = target + sum(P) + sum(N) =>
 * 2 * sum(P) = target + sum(nums) =>
 * sum(P) = (target + sum(nums)) / 2 =>  
 * target + sum(nums)必须是一个偶数.
 */
var findTargetSumWays = function (nums, S) {
    let sum = eval(nums.join('+')); // 5
    if (sum < S || (S + sum) % 2 === 1) return 0;
    let w = Math.floor((sum + S) / 2); // 3
    let list = Array(w + 1).fill(0);
    list[0] = 1;
    for (let i = 0; i < nums.length; i++) {
        for (let j = w; j >= nums[i]; j--) {
            console.log('-------------');
            console.log(j);
            console.log(i, nums[i]);
            console.log(list);
            console.log('-------------');

            list[j] += list[j - nums[i]];
        }
        console.log(list);

    }
    return list[w];
};


/**
 * 
 * @param {number[]} nums 
 * @param {number} S 
 * @return {number}
 * @description dfs太慢
 */
var findTargetSumWays2 = function (nums, S) {
    if (S > 1000 || S < -1000) return 0;
    let count = 0;
    let len = nums.length;

    function dp(sum, counter) {
        if (counter === len) {
            if (sum === S) count++;
            return;
        }
        dp(sum + nums[counter], counter + 1);
        dp(sum - nums[counter], counter + 1);
    }
    dp(0, 0);
    return count;
};

console.log(findTargetSumWays([1, 2, 3, 4, 5], 5));