/*
 * @lc app=leetcode.cn id=400 lang=php
 *
 * [400] 第N个数字
 */

// @lc code=start
class Solution {

    /**
     * @param Integer $n
     * @return Integer
     */
    function findNthDigit($n) {
        $up = 1;
        $count = 0;
        while (1) {
            $max = pow(10, $up);
            $serial = $max - (pow(10, $up - 1));
            $count += $serial * $up;

            if ($count >= $n) {
                $offset = $n - ($count - $serial * $up);
                $index = ($offset - 1) / $up;
                $sub = ($offset - 1) % $up;

                $item = pow(10, $up - 1) + $index;
                return str_split($item)[$sub];
            }
            $up++;
        }
    }
}
