/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function (nums, target) {
    if (nums.length == 0) return [-1, -1];


    function index(flag) {
        let left = 0;
        let right = nums.length - 1;
        while (left < right) {
            let mid = Math.round((left + right) / 2);
            //如果查找为相同的则左移  查找右边界
            //如果查找为相同的则右移  查找左边界
            if (target == nums[mid]) {
                if (flag)
                    left = mid + 1;
                else
                    right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    let right = index(true); //找出最右的边界
    let left = index(false); //找出最左的边界
    //根据输入的数据个数不同，查找出来的左右边界会出现不同的值
    //少一位或者多一位，但是少或者多一个位数
    //所以我们可以判断一下 下一个数是否等于target
    //对于左边的边界值left加1  右边的边界值减1
    //以上是对于存在的情况
    //如果不存在这个数则会返回left = right = 0;
    //这时我们只需要判断下个数是否等于target 如果不等于就返回-1

    if (nums[left] != target) {
        left++;
        left = left >= nums.length ? -1 : (nums[left] != target ? -1 : left);
    }
    if (nums[right] != target) {
        right--;
        right = right < 0 ? -1 : (nums[right] != target ? -1 : right);
    }

    return [left, right]

};




console.log(searchRange([5, 6, 8, 8, 9, 10], 8));