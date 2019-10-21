/*
 * @lc app=leetcode.cn id=33 lang=php
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function search($nums, $target) {
        $low = 0;
        $height = count($nums) - 1;

        if ($target >= $nums[$low]) {
            while ($nums[$low] > $nums[$height]) {
                $height--;
            }
        } else {
            while ($nums[$low] > $nums[$height]) {
                $low++;
            }
        }

        while ($low <= $height) {
            $mid = intval(($low + $height) / 2);

            if ($target == $nums[$mid]) {
                return $mid;
            } elseif ($target > $nums[$mid]) {
                $low = $mid + 1;
            } else {
                $height = $mid - 1;
            }
        }

        return -1;
    }
}
