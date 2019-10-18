# _*_ coding: utf-8 _*_


class Solution:
    def threeSumClosest(self, nums, target) -> int:
        nums.sort()
        result = nums[0] + nums[1] + nums[2]
        if result == target:
            return target
        for i in range(len(nums) - 2):
            left = i + 1
            right = len(nums) - 1
            while left != right:
                sum_num = nums[i] + nums[left] + nums[right]
                if sum_num == target:
                    return target
                elif sum_num < target:
                    left += 1
                    while left != right and nums[left] == nums[left - 1]:
                        left += 1
                elif sum_num > target:
                    right -= 1
                    while left != right and nums[right] == nums[right + 1]:
                        right -= 1
                if abs(sum_num - target) < abs(result - target):
                    result = sum_num
        return result


if __name__ == '__main__':
    list = [-1, 2, 1, -4]
    t = 1
    solution = Solution()
    res = solution.threeSumClosest(list, t)
    print(res)
