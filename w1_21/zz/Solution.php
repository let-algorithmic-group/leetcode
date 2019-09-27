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
        if($l1 == null){
            return $l2;
        }
        if($l2 == null){
            return $l1;
        }
        if($l1->val < $l2->val){
            $l1->next = self::mergeTwoLists($l1->next,$l2);
           return $l1;
        }else{
            $l2->next = self::mergeTwoLists($l1,$l2->next);
           return $l2;
        }
    }
}
