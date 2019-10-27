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
        return $this->searchArray($nums, 0, count($nums) - 1, $target);
    }

    public function searchArray($nums, $start, $end, $target)
    {
        if ($start > $end) {
            return -1;
        }
        $mid = floor(($end + $start) / 2);
        if ($nums[$mid] == $target) {
            return $mid;
        } elseif ($nums[$mid] < $nums[$end]) {
            if ($nums[$mid] < $target && $target <= $nums[$end]) {
                return $this->searchArray($nums, $mid + 1, $end, $target);
            } else {
                return $this->searchArray($nums, $start, $mid - 1, $target);
            }
        } else {
            if ($nums[$start] <= $target && $target < $nums[$mid]) {
                return $this->searchArray($nums, $start, $mid - 1, $target);
            } else {
                return $this->searchArray($nums, $mid + 1, $end, $target);
            }
        }
    }
}