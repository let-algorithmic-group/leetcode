<?php
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
        if(!$head || !$head->next) return $head;
        $slow=$fast=$head;
        while($fast && $fast->next){
            $pre=$slow;
            $fast=$fast->next->next;
            $slow=$slow->next;
        }
        $pre->next=null;
        return $this->merge($this->sortlist($head),$this->sortlist($slow));
    }
    
    function merge($l1,$l2){
         if(!$l1){
            return $l2;
        }
        if(!$l2){
            return $l1;
        }
        $list = new ListNode(0);    
        $current =  $list;  // 对象是引用类型，即这里的 current 和 list 是一个存储引用位置。当后续 current 改变则 list 也改变。不过这里需要注意的是，如果 current 改变类型，那么就是不同的位置了，后续不能继续同步修改.
        while($l1 || $l2){
            if(!$l1){
                $current->next = $l2;
                break;
            }
            if(!$l2){
                $current->next = $l1;
                break;
            }
            if($l1->val <= $l2->val){
                $current->next = $l1;  //current 链表的下一个指向为 l1 链表
                 $current = $current->next;  // 这里 current 链表不是重新赋值，而只是移动原来的指针到下一个指针，比如如果之前 list 和 current 等于 0 1 2 3, 那么当 current = current->next 的时候，只是 current 向后移动一个指针，等于 1 2 3, 实际上 current 和 list 还是一个存储引用，后续如果 current->next 改变那么 list 也会改变.
                $l1 = $l1->next; // 这里把 l1 的链表指针走向下一个.
            }else{
                $current->next = $l2;
                $current = $current->next;
                $l2 = $l2->next;
            }
        }
        return $list->next; // 因为 current 每次 next 都放进去，那么 list 实际上从一开始指针都是在 0 那里，所以这里返回的时候直接返回 0 以后的元素即可.
    
    }
}