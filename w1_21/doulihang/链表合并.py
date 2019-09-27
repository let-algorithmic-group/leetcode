#!usr/bin/env python
#-*- coding:utf-8 -*-
"""
@author:doulihang
@file: 链表合并.py
@time: 2019/09/27
"""
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        node = ListNode(0)
        l3 = node
        while l1 and l2:
            if l1.val < l2.val:
                l3.next = l1
                l1 = l1.next
            else:
                l3.next = l2
                l2 = l2.next
            l3 = l3.next
        if l1 != None:
            l3.next = l1
        else:
            l3.next = l2
        return node.next
    