// test
package main

import (
	"fmt"
)

func main() {
	l1 := ListNode{
		Val: 4,
		Next: &ListNode{
			Val: 3,
			Next: &ListNode{
				Val:  -8,
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
	ret := sortList(&l1)
	fmt.Println(ret.toString())

	fmt.Println("l1:", l1.toString())
	fmt.Println("l2:", l2.toString())
	//fmt.Println("merge result:", mergeTwoLists(&l1, &l2).toString())
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
	var target *ListNode
	for {
		if l1Index == nil && l2Index == nil {
			break
		}

		if l1Index == nil {
			target = l2Index
			l2Index = l2Index.Next
		} else if l2Index == nil {
			target = l1Index
			l1Index = l1Index.Next
		} else {
			if l1Index.Val < l2Index.Val {
				target = l1Index
				l1Index = l1Index.Next
			} else {
				target = l2Index
				l2Index = l2Index.Next
			}
		}
		retTail.Next = target
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

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func sortList(head *ListNode) *ListNode {
	var list []*ListNode

	next := head
	for {
		if nil == next {
			break
		}
		var node ListNode
		node.Val = next.Val
		list = append(list, &node)
		next = next.Next
	}
	endIndex := len(list) - 1
	if endIndex < 0 {
		return nil
	}
	for {
		if endIndex <= 0 {
			break
		}
		index := 0
		for {
			if index > endIndex {
				break
			}
			if index+1 <= endIndex {
				list[index/2] = mergeTwoLists(list[index], list[index+1])
			} else {
				list[index/2] = list[index]
			}
			index = index + 2
		}
		endIndex = index/2 - 1
	}
	return list[0]
}
