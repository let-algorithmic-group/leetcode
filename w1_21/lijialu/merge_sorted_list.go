package main

import (
	"fmt"
)

func main() {
	l1 := ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 3,
			Next: &ListNode{
				Val:  8,
				Next: nil,
			},
		},
	}
	l2 := ListNode{
		Val: 4,
		Next: &ListNode{
			Val: 5,
			Next: &ListNode{
				Val:  9,
				Next: nil,
			},
		},
	}
	fmt.Println("l1:", l1.toString())
	fmt.Println("l2:", l2.toString())
	fmt.Println("merge result:", mergeTwoLists(&l1, &l2).toString())
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	if l2 == nil {
		return l1
	}
	if l1 == nil {
		return l2
	}

	merged := &ListNode{Val: l1.Val, Next: nil}
	if l1.Val >= l2.Val {
		merged = &ListNode{Val: l2.Val, Next: nil}
		l2 = l2.Next
	} else {
		l1 = l1.Next
	}
	res := merged
	for {
		if l1 == nil {
			merged.Next = l2
			break
		}
		if l2 == nil {
			merged.Next = l1
			break
		}
		if l1.Val > l2.Val {
			merged.Next = &ListNode{Val: l2.Val, Next: nil}
			l2 = l2.Next
		} else {
			merged.Next = &ListNode{Val: l1.Val, Next: nil}
			l1 = l1.Next
		}
		merged = merged.Next
	}
	return res
}


func (l ListNode) toString() string {
	var out string
	out = fmt.Sprintf("%v", l.Val)
	next := l.Next
	for {
		if nil == next {
			break
		}
		out = fmt.Sprintf("%v,%v", out, next.Val)
		next = next.Next
	}
	return out
}