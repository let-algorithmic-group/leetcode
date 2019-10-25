/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */

var search = function(nums, target) {
    var max = Math.max.apply(null,nums);
    var min = Math.min.apply(null,nums);
    var start, end, index, len=nums.length;

    if (target > nums[len-1]) {
        start = 0;
        end =nums.indexOf(max)
    } else {
        start = nums.indexOf(min);
        end = len-1
    }
    while(start <= end) {

        index = Math.ceil((start + end) / 2)

        if (nums[index] === target) return index;

        nums[index] > target ? end = index - 1 : start = index + 1
    }

    return -1;

};
