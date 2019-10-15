/*
 * @lc app=leetcode.cn id=16 lang=php
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function threeSumClosest($nums, $target) {
        sort($nums);
        $length = count($nums);
        $result = $nums[0] + $nums[1] + $nums[2];

        for ($i = 0; $i < $length - 2; $i++) {
            $low = $i + 1;
            $height = $length - 1;

            while ($low < $height) { 
                $sum = $nums[$i] + $nums[$low] + $nums[$height];
                if (abs($sum - $target) < abs($result - $target)) {
                    $result = $sum;
                }

                if ($sum == $target) {
                    return $sum;
                } elseif ($sum > $target) {
                    $height--;
                } elseif ($sum < $target) {
                    $low++;
                }
            }
        }

        return $result;
    }
}
