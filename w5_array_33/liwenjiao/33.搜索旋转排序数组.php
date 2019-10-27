<?php


class Solution
{

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function search($nums, $target)
    {
        $low = 0;
        $hight = count($nums) - 1;
        while ($low <= $hight) {
            $mid = floor(($low + $hight) / 2);
            if ($target == $nums[$mid]) {
                return $mid;
            } elseif ($nums[$mid] < $nums[$hight]) {
                if ($nums[$mid] < $target && $target <= $nums[$hight]) {
                    $low = $mid + 1;
                } else {
                    $hight = $mid - 1;
                }
            } else {
                if ($target >= $nums[$low] && $target < $nums[$mid]) {
                    $hight = $mid - 1;
                } else {
                    $low = $mid + 1;
                }
            }
        }
        return -1;
    }
}
