class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        slow, fast = head, head.next
        while fast and fast.next:
            fast, slow = fast.next.next, slow.next
        mid, slow.next = slow.next, None
        left, right = self.sortList(head), self.sortList(mid)
        temp = ListNode(0)
        res = temp
        while left and right:
            if left.val < right.val:
                temp.next, left = left, left.next
            else:
                temp.next, right = right, right.next
            temp = temp.next
        temp.next = left or right
        return res.next
