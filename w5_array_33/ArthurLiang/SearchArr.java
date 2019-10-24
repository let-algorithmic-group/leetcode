package com.arthur.liang;

public class SearchArr {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                low = mid + 1;
            } else if (target > nums[mid] && target < nums[0]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low == high && nums[low] == target ? low : -1;
    }

    public int binarySearch(int[] nums, int target, int low, int high) {
        if (target < nums[low] || target > nums[high] || low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[mid] > target) {
            return binarySearch(nums, target, low, mid - 1);
        } else if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, high);
        } else {
            return mid;
        }
    }
}
