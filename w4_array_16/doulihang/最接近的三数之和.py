#!usr/bin/env python
#-*- coding:utf-8 -*-
"""
@author:doulihang
@file: 最接近的三数之和.py
@time: 2019/10/18
"""


class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        res = 2147483647
        n = len(nums)
        for i in range(n - 1):
            left = i + 1
            right = n - 1

            while left < right:
                sum = nums[i] + nums[left] + nums[right]
                if res == target:
                    return res
                if abs(res - target) > abs(sum - target):
                    res = sum
                if sum < target:
                    left += 1
                else:
                    right -= 1
        return res