package main

import (
	"fmt"
	"math"
)

func main() {
	nums := []int{-1, 2, 1,-4}
	fmt.Println(threeSumClosest(nums, 1))
}

func threeSumClosest(nums []int, target int) int {
	var sum int
	var diff int
	var res int
	minDiff := math.MaxInt16

	length := len(nums) -1
	i := 0


	for ; i <= length; i++ {
		for j:=0; j <= length; j++ {
			if i == j {
				continue
			}
			for k:=0; k <= length; k++ {
				if i == k || j ==k {
					continue
				}

				sum = nums[i] + nums[j] + nums[k]
				fmt.Println(i,j,k,nums[i],nums[j],nums[k])
				diff = int(math.Abs(float64(sum-target)))
				if diff < minDiff {
					minDiff = diff
					res = sum
				}
			}
		}
	}

	return res
}
