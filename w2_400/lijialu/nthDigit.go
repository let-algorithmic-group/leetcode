package main

import (
	"fmt"
	"math"
	"strconv"
)

func main() {
	fmt.Println(findNthDigit(11))
}

func findNthDigit(n int) int {
	var res int
	//位数
	var place = 1
	//计算出的总数
	var total = 0
	var current = 0
	for {
		current = place * 9 * math.Pow(10, (place - 1))
		total += current
		if n <= total {
			break
		}
		place++
	}
	fmt.Println("place", place)
	fmt.Println("total", total)
	fmt.Println("a", current)

	// 计算区间最低值
	numFloor := pow(10, place-1)
	fmt.Println("num", numFloor)
	// 计算走到n位落到了那一个数(n减去numFloor的位数后除以目前区间的位数)
	currentPlace := (n - (total - current) - 1)
	step := currentPlace / place
	fmt.Println("step", step)
	// 计算走到n落到了哪一位(取余)
	digit := currentPlace % place
	fmt.Println("digit", digit)
	res = numFloor + step
	fmt.Println("res_num", res)
	resString := strconv.Itoa(res)
	res, _ = strconv.Atoi(resString[digit:(digit + 1)])
	return res
}

func pow(x, n int) int {
	ret := 1 // 结果初始为0次方的值，整数0次方为1。如果是矩阵，则为单元矩阵。
	for n != 0 {
		if n%2 != 0 {
			ret = ret * x
		}
		n /= 2
		x = x * x
	}
	return ret
}
