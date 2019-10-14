<?php

class Solution
{

    /**
     * @param Integer $n
     * @return Integer
     */
    function findNthDigit($n)
    {
        $i = 0;
        while (1) {
            if ($n - ($i + 1) * 9 * pow(10, $i) > 0) {
                $n -= ($i + 1) * 9 * pow(10, $i);
                $i++;
                continue;
            }
            $a = ($n - 1) / ($i + 1);
            $b = ($n - 1) % ($i + 1);
            $num = pow(10, $i) + $a;
            for ($j = 0; $j < $i - $b; $j++) {
                $num = $num / 10;
            }
            $num = $num % 10;
            return $num;
        }

    }
}