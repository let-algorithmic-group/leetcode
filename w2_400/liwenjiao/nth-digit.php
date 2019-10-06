<?php
class Solution
{

    /**
     * @param Integer $n
     * @return Integer
     */
    function findNthDigit($n)
    {
        $i = 1;
        $len = 0;
        while ($n > $len) {
            $len += $i * 9 * pow(10, $i - 1);
            $i++;
        }
        $i -= 1;
        $len -= $i * 9 * pow(10, $i - 1);
        $n -= $len;
        $x = (string) (($n - 1) / $i + pow(10, $i - 1));
        $y = ($n - 1) % $i;
        return $x[$y];
    }
}
