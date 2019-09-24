# _*_ coding: utf-8 _*_
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def append(l, node):
    if not l:
        return node
    cur = l
    while cur.next is not None:
        cur = cur.next
    cur.next = node
    return l


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1:
            return l2
        if not l2:
            return l1

        new = None
        while l1 and l2:

            if l1.val < l2.val:
                node = ListNode(l1.val)
                l1 = l1.next
            else:
                node = ListNode(l2.val)
                l2 = l2.next
            new = append(new, node)

        if l1:
            new = append(new, l1)
        else:
            new = append(new, l2)

        return new


if __name__ == '__main__':
    l1 = ListNode(1)
    l1.next = ListNode(2)
    l1.next.next = ListNode(4)

    l2 = ListNode(1)
    l2.next = ListNode(3)
    l2.next.next = ListNode(4)

    solution = Solution()
    new_l = solution.mergeTwoLists(l1, l2)
    while new_l is not None:
        print(new_l.val, end=' ')
        new_l = new_l.next
