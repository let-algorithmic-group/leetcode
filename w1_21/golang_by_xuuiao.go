// test
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
	l1Index := l1
	l2Index := l2
	var ret ListNode
	retTail := &ret
	for {
		if l1Index == nil && l2Index == nil {
			break
		}
		var target ListNode
		if l1Index == nil {
			target.Val = l2Index.Val
			l2Index = l2Index.Next
		} else if l2Index == nil {
			target.Val = l1Index.Val
			l1Index = l1Index.Next
		} else {
			if l1Index.Val < l2Index.Val {
				target.Val = l1Index.Val
				l1Index = l1Index.Next
			} else {
				target.Val = l2Index.Val
				l2Index = l2Index.Next
			}
		}
		retTail.Next = &target
		retTail = retTail.Next
	}
	return ret.Next
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
