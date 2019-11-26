package main

func singleNumber(nums []int) int {
	var single = 0
	for _, i := range nums{
		single ^=i
	}

	return single
}
