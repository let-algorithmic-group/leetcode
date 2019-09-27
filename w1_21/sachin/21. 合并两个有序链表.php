<?php

/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val) { $this->val = $val; }
 * }
 */
class Solution
{
    public $_firstNode;

    /**
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     */
    function mergeTwoLists($l1, $l2)
    {

        //将链表转化为数组
        $array1 = $this->display($l1);
        $array2 = $this->display($l2);


        //合并两个数组
        $array = array_merge($array1, $array2);

        //对数组进行排序
        $array = $this->order($array);

        //将排序后的数组重新转化为链表
        foreach ($array as $key => $value) {
            $this->insert($value);
        }
        return $this->_firstNode;
    }

    //遍历链表并返回数组
    function display($currentNode)
    {
        $temp = [];

        //过滤一些极端数据
        if ($currentNode->next === NULL && $currentNode->val === NULL) {
            return $temp;
        }

        while ($currentNode->next !== NULL) {
            array_push($temp, $currentNode->val);
            $currentNode = $currentNode->next;
        }
        array_push($temp, $currentNode->val);
        return $temp;
    }

    //向链表中insert新的数据
    function insert($data)
    {
        $newNode = new ListNode($data);

        if ($this->_firstNode === NULL) {
            $this->_firstNode = &$newNode;
        } else {
            $currentNode = $this->_firstNode;
            while ($currentNode->next !== NULL) {
                $currentNode = $currentNode->next;
            }
            $currentNode->next = $newNode;
        }
        return TRUE;
    }

    //对数组进行排序
    function order($arr)
    {
        $count = count($arr);
        for ($i = 0; $i < $count - 1; $i++) {
            $minIndex = $i;
            for ($j = $i + 1; $j < $count; $j++) {
                if ($arr[$j] < $arr[$minIndex]) {
                    $minIndex = $j;
                }
            }
            if ($i != $minIndex) {
                $temp = $arr[$i];
                $arr[$i] = $arr[$minIndex];
                $arr[$minIndex] = $temp;

            }
        }
        return $arr;
    }
}

