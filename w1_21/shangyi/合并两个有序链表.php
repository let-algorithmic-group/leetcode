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
        if (!$l1) {
            return $l2;
        }
        if (!$l2) {
            return $l1;
        }
        //将输入对象转化为数组
        $l1 =  json_decode(json_encode($l1),true);
        $l2 =  json_decode(json_encode($l2),true);
        $l1_r = $this->listsTransToArray($l1);
        $l2_r = $this->listsTransToArray($l2);
        $l3_r = array_merge($l1_r,$l2_r);
        $l3_r_r = $this->bucketSort($l3_r);
        $l3 = $this->arrayTransToLists($l3_r_r);
        //将数组转化为输出对象
        $l3 =  json_decode(json_encode($l3));
        return $l3;
          
    }

    //将链表转化为数组
	function listsTransToArray($lists,$res = []) {
		$res[] = $lists['val'];
		if (!$lists['next']) {
			return $res;
		} else {
			return $this->listsTransToArray($lists['next'],$res);
		}

	}

    //将数组转化为链表
	function arrayTransToLists($array,$res = null) {
		$count = count($array);
		if (!isset($array[$count-1])) {
			return $res;
		} else {
			$res['next'] = $res;
			$res['val'] = $array[$count-1];
			unset($array[$count-1]);
			return $this->arrayTransToLists($array, $res);
		}
	}

    //实现桶排序
	function bucketSort($arr) {
        $min = -100;
        $max = 100;
        $res = $return = [];

        for ($i=$min;$i<=$max;$i++) {
           $res[$i] = 0;
        }
        
        $count = count($arr);
        for ($j=$min;$j<$count;$j++) {
        	if (isset($arr[$j])) {
				$res[$arr[$j]]++;
        	}
        }
        for ($m=$min;$m<=$max;$m++) {
            for ($n=0;$n<$res[$m];$n++) {
                $return[] = $m;
            }
        }
        
        return $return;
        
	}
}