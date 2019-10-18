package test10181;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        threeSumClosest(nums, target);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        if (result == target) {
            return result;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left != right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    right--;
                    while (left != right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else {
                    left++;
                    while (left != right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return result;
    }
}
