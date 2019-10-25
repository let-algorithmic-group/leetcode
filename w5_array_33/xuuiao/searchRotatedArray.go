// searchRotatedArray
package main

import (
	"fmt"
)

func main() {
	//fmt.Println("Hello World!")
	a := []int{1, 2, 3, 4}
	fmt.Println(search(a, 9))
}

func search(nums []int, target int) int {
	start := 0
	end := len(nums) - 1
	mid := (start + end) / 2
	if nums[start] == target {
		return start
	}
	if nums[end] == target {
		return end
	}
	//isSortedArray := false
	for {
		if nums[mid] == target {
			return mid
		}

		//检查左边数组是否有序
		if nums[start] <= nums[mid] {
			// 左边有序
			if target >= nums[start] && target <= nums[mid] {
				// 目标数字在有序数组中
				//isSortedArray = true
				end = mid
				mid = (start + end) / 2

			} else {
				// 目标数字在右边无序数组中
				start = mid
				mid = (start + end) / 2
			}
		} else {
			// 右边有序
			if target >= nums[mid] && target <= nums[end] {
				start = mid
				mid = (start + end) / 2
			} else {
				end = mid
				mid = (start + end) / 2
			}
		}
		if start == end {
			if nums[start] == target {
				return start
			} else {
				return -1
			}
		}
		if mid == start || mid == end {
			return -1
		}
	}
}
