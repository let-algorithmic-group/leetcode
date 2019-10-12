#!usr/bin/env python
#-*- coding:utf-8 -*-
"""
@author:doulihang
@file: 排序链表.py
@time: 2019/10/12
"""
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        #链表为空或只有1个节点，直接将该链表返回
        if not head or not head.next:
            return head
        # 将链表从中间进行分割
        slow, fast = head, head.next
        while fast and fast.next:
            fast, slow = fast.next.next, slow.next
        #保存中间节点
        mid, slow.next = slow.next, None
        # 对分割后的链表重新进行分割
        left, right = self.sortList(head), self.sortList(mid)
        # merge `left` and `right` linked list and return it.
        h = res = ListNode(0)
        #比较后，进行合并
        while left and right:
            if left.val < right.val:
                h.next, left = left, left.next
            else:
                h.next, right = right, right.next
            h = h.next
        h.next = left if left else right
        return res.next