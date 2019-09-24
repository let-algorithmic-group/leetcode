/*
 * @lc app=leetcode.cn id=21 lang=php
 *
 * [21] 合并两个有序链表
 */
/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val) { $this->val = $val; }
 * }
 */
class Solution {

    /**
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     */
    function mergeTwoLists($l1, $l2) {
        if (is_null($l1) && !is_null($l2)) {
            return $l2;
        } elseif (is_null($l2) && !is_null($l1)) {
            return $l1;
        } elseif (is_null($l1) && is_null($l2)) {
            return null;
        }

        $list = new stdClass;
        $list->val = 0;
        $list->next = null;
        $temp = $list;

        while (1) {
            if ($l1->val < $l2->val) {
                $temp->val = $l1->val;
                $l1 = $l1->next;
            } else {
                $temp->val = $l2->val;
                $l2 = $l2->next;
            }

            if (is_null($l1) && !is_null($l2)) {
                $temp->next = $l2;
                break;
            } elseif (is_null($l2) && !is_null($l1)) {
                $temp->next = $l1;
                break;
            } elseif (is_null($l1) && is_null($l2)) {
                break;
            }
            $temp->next = new stdClass;
            $temp->next->val = 0;
            $temp->next->next = null;
            $temp = $temp->next;
        }

        return $list;
    }
}
