class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function threeSumClosest($nums, $target) {
        sort($nums);
        $hedNum = $nums[0] + $nums[1] +$nums[2];
        for($i=0; $i<= count($nums)-2; $i++){
            $l = $i+1;
            $r = count($nums) -1;
            while($l < $r){
                $threeSum = $nums[$l] + $nums[$r] + $nums[$i];
                if(abs($threeSum - $target) < abs($hedNum - $target)){
                    $hedNum = $threeSum;
                }
                if ($threeSum > $target){
                    $r--;
                } else if ($threeSum < $target){
                    $l++;
                } else {
                    return $target;
                }
            }
        }
        return $hedNum;
    }
}
