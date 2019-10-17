/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function (nums, target) {
    // nums.sort((a, b) => (a - b))
    // let ans = nums[0] + nums[1] + nums[2];
    // for (let index = 0; index < nums.length; index++) {
    //     const element = nums[index];
    //     let start = index + 1;
    //     let end = nums.length - 1;
    //     while (start < end) {
    //         let sum = element + nums[start] + nums[end]
    //         if (Math.abs(target - sum) < Math.abs(target - ans)) {
    //             ans = sum
    //         } else if (sum > target) {
    //             end--;
    //         } else if (sum < target) {
    //             start++;
    //         } else {
    //             return ans;
    //         }
    //     }
    // }
    // return ans;

    // 暴力破解
    // let n = nums.length;
    // let dif = 2100000000,
    //     ans;
    // for (let i = 0; i < n; i++) {
    //     for (let j = i + 1; j < n; j++) {
    //         for (let k = j + 1; k < n; k++) {
    //             let sum = nums[i] + nums[j] + nums[k];
    //             if (Math.abs(sum - target) < dif) {
    //                 dif = Math.abs(sum - target);
    //                 ans = sum;
    //             }
    //         }
    //     }
    // }
    // return ans;


    // 贪心算法
    // let ret = Number.MAX_VALUE;
    // let temp = Number.MAX_VALUE;
    // let count = 0;
    // let res = 0;
    // for (let i = 0; i < nums.length - 2; i++) {
    //     for (let j = i + 1; j < nums.length - 1; j++) {
    //         for (let k = j + 1; k < nums.length; k++) {
    //             count = nums[i] + nums[j] + nums[k];
    //             temp = Math.abs(count - target);
    //             if (ret > temp) {
    //                 ret = temp;
    //                 res = count;
    //             } else continue;
    //         }
    //     }
    // }
    // return res;
};

threeSumClosest([-1, 2, 1, -4], 1)