class Solution {

    /**
     * @param Integer $n
     * @return Integer
     */
    function findNthDigit($n) {
        if($n<10){
            return $n;
        }
        $i= 0;
        $nmax = 0;
        while ($nmax < $n) {
            $i++;
            $nmax = $nmax + 9* pow(10,$i-1)*$i;
        }
        $num = $n-( $nmax - 9* pow(10,$i-1)*$i);
        $temp = $num / $i;
        if($num % $i == 0){
            $temp =$temp -1;
        }
        $res = $temp + pow(10,$i-1);
        return intval(strval($res)[$num % $i - 1]);
        
    }
}
