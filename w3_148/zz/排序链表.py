# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def __init__(self):
        self._head = None
    def sortList(self, head):
        if not head or not head.next:
            return head
        stack = []
        cur = head 
        while cur:
            stack.append(cur.val)
            cur = cur.next
        stack = sorted(stack)
        while stack:
            node = ListNode(stack.pop())
            node.next = self._head
            self._head = node
        return self._head
