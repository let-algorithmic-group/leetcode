package main

import (
	"fmt"
)

func main() {
	l1 := ListNode{
		Val: 4,
		Next: &ListNode{
			Val: 2,
			Next: &ListNode{
				Val: 1,
				Next: &ListNode{
					Val:  3,
					Next: nil,
				},
			},
		},
	}
	sortList(&l1)
	//fmt.Println("l1:", res)
}

type ListNode struct {
	Val  int
	Next *ListNode
}

type MaxHeap struct {
	Element []int
}

func sortList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	var a [] int
	for {
		a = append(a, head.Val)
		head = head.Next
		if (head == nil) {
			break
		}
	}
	fmt.Println(a)
	// 构建大顶堆
	buildHeap(a)

	fmt.Println(a)
	// 首尾交换，重新构建大顶堆
	for i := len(a) - 1; i >= 0; i-- {
		a[0], a[i] = a[i], a[0]
		adjustHeap(a, 0, i)
	}
	fmt.Println(a)
	return head
}

func adjustHeap(a []int, pos int, lenght int) {
	for {
		// 计算孩子位置
		child := pos*2 + 1
		// 检查孩子是否越界
		if child >= (lenght - 1) {
			break
		}

		// 找出孩子中较大的那个
		if a[child+1] > a[child] {
			child++
		}
		// 检查孩子是否大于父亲，如果大于则交换
		if a[pos] < a[child] {
			// 父子交换
			a[pos], a[child] = a[child], a[pos]
			// 更新位置，指向子节点
			pos = child
		} else {
			// 如果子节点都小于父节点了，那就可以结束调整了
			break
		}
	}
}

func buildHeap(a []int) {
	// 从底层向上层构建，len(a)/2-1是第一个非叶子
	for i := len(a)/2 - 1; i >= 0; i-- {
		adjustHeap(a, i, len(a))
	}
}
