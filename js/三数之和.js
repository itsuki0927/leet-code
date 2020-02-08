var threeSum = function (nums) {
    let list = []
    nums.sort((a, b) => (a - b))
    let size = nums.length
    if (nums[0] <= 0 && nums[size - 1] >= 0) {
        let i = 0
        while (i < size - 2) {
            if (nums[i] > 0) break;
            let first = i + 1
            let last = size - 1
            while (first < last) {
                if (nums[i] * nums[last] > 0) break

                let sum = nums[i] + nums[first] + nums[last]

                if (!sum) {
                    list.push([nums[i], nums[first], nums[last]])
                }
                if (sum <= 0) {
                    while (nums[first] === nums[++first]);
                } else {
                    while (nums[last] === nums[--last]);
                }
            }
            while (nums[i] === nums[++i]);
        }
    }
    return list
};


threeSum([-1, 0, 1, 2, -1, -4])