package main

import (
	"fmt"
	"math"
)

func main() {
	a := 31
	fmt.Println(findNthDigit(a))
	fmt.Println(int64(math.Pow(2, 32)))
}

func findNthDigit(n int) int {
	if n < 10 {
		return n
	}
	x, y := getX(n)
	//fmt.Println("x,y:", x, y)
	leftNum := n - y
	//fmt.Println("leftDigit:", leftNum)
	line := (leftNum - 1) / ((x + 1) * 10)
	//fmt.Println("line:", line)
	lineIndex := int(math.Mod(float64(leftNum-1), float64((x+1)*10)))
	//fmt.Println("lineIndex:", lineIndex)
	lineNum := lineIndex / (x + 1)
	//fmt.Println("当前行第几个数字：", lineNum)
	lineNumIndex := int(math.Mod(float64(lineIndex), float64(x+1)))
	//fmt.Println("数字中第几个数", lineNumIndex)
	theNumber := int(math.Pow10(x)) + line*10 + lineNum
	//fmt.Println("定位到的数字：", theNumber)
	return int(math.Mod(float64(theNumber/(int(math.Pow10((x+1)-lineNumIndex-1)))), 10))
}

//
func getX(n int) (int, int) {
	x := 0
	y := 0
	var maxNum int
	for {
		maxNum = (x + 1) * 9 * int(math.Pow10(x))
		if maxNum > n {
			break
		} else {
			y = y + maxNum
			x++
		}
	}
	return x, y
}
