// threeSumClosest
package main

import (
	"fmt"
	"sort"
)

func main() {
	//nums := []int {1, 2, 4, 5, 6, 7, -44, -32, 53, 34, 15, 13}
	nums := []int{1, 2, 4, 5, 6, 7, -4, -2}
	ret := threeSumClosest(nums, 11)
	fmt.Println(ret)
}

func threeSumClosest(nums []int, target int) int {
	sort.Ints(nums)
	baseIndex := 0
	length := len(nums)
	closestSum := nums[0] + nums[1] + nums[2]
	var sum int
	for {
		if baseIndex >= length-2 {
			break
		}
		startIndex := baseIndex + 1
		endIndex := length - 1
		for {
			if startIndex >= endIndex {
				break
			}
			sum = nums[baseIndex] + nums[startIndex] + nums[endIndex]
			if sum == target {
				return sum
			}
			if intAbs(sum-target) < intAbs(closestSum-target) {
				closestSum = sum
			}
			if sum < target {
				startIndex++
			} else {
				endIndex--
			}
		}
		baseIndex++
	}
	return closestSum
}

func intAbs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}
