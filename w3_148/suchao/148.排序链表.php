/*
 * @lc app=leetcode.cn id=148 lang=php
 *
 * [148] 排序链表
 */

// @lc code=start
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
     * @param ListNode $head
     * @return ListNode
     */
    function sortList($head) {
        $length = 1;
        $origin = $head;
        $sup = 1;

        while ($origin = $origin->next) {
            $length++;
        }

        $list = new ListNode(0);
        $list->next = $head;
        while ($sup < $length) {

            $tmp = $list;
            $origin = $list->next;
            while ($origin) {
                $l1 = $origin;
                $i = $sup;
                while ($i && $origin) {
                    $i--;
                    $origin = $origin->next;
                }

                if ($i) {
                    break;
                }

                $l2 = $origin;
                $i = $sup;
                while ($i && $origin) {
                    $i--;
                    $origin = $origin->next;
                }

                $c1 = $sup;
                $c2 = $sup - $i;
                while ($c1 && $c2) {
                    if ($l1->val < $l2->val) {
                        $tmp->next = $l1;
                        $l1 = $l1->next;
                        $c1--;
                    } else {
                        $tmp->next = $l2;
                        $l2 = $l2->next;
                        $c2--;
                    }
                    $tmp = $tmp->next;
                }
                $tmp->next = $c1 ? $l1 : $l2;
                while ($c1 > 0 || $c2 > 0) {
                    $tmp = $tmp->next;
                    $c1--;
                    $c2--;
                }
                $tmp->next = $origin;
            }

            $sup *= 2;
        }
        return $list->next;
    }
}
