class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function search($nums, $target) {
        if (!is_array($nums) || empty($nums)) {
            return -1;
        }
        $len = count($nums);
        $lower = 0;
        $high = $len - 1;
        while ($lower <= $high) {
            $middle = floor(($lower + $high) / 2);
            if ($nums[$middle] == $target) {
                return $middle;
            }
            if ($nums[$middle] < $nums[$high]){
                if ($nums[$middle] < $target && $target<= $nums[$high]){
                    $lower = $middle + 1;
                } else {
                    $high = $middle - 1;
                }
            } else{
                 if ($nums[$lower] <= $target && $target< $nums[$middle]){
                    $high = $middle - 1;
                } else {
                    $lower = $middle + 1;
                }
            }
        }
         return -1;
    }
}
