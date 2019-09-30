class Solution {

    //解题思路：
    //首先总结数学规律，将输入值的位数与一个个区间极限值对应起来，对应规则为 9 * n *（10的n-1次方）
    //然后根据实例，分析落在区间的值的特殊性。 用该值除以区间值 所得除数和余数，是获得最终值的关键
    //根据实验，发现最终的输出值即为 除数的余数位 的值
    //ps：注意一些特殊情况


    /**
     * @param Integer $n
     * @return Integer
     */
    function findNthDigit($n) {
        $divisor = $this->calculateStep($n);
        //没去做兼容，直接粗暴将小于10的数值区分出来
        if ($divisor>1) {
            $res = $this->getLastQuery($n, $divisor);
        } else {
            $res = $n;
        }
        return $res;
    }
    
    //逻辑实现
    function getLastQuery($val, $divisor) {
        $val = $this->proccessHandling($val, $divisor);
        $r = intval(($val+$divisor*pow(10,$divisor-1)) / $divisor);
        $r1 = intval($val % $divisor);
        $result = $this->breakUpVal($r,$r1);
        return $result;
    }

    //计算落在区间的值的大小
    function proccessHandling($val, $divisor) {
        $sum = 0;
        for($i=1;$i<$divisor;$i++) {
            $sum += $this->countValue($i);
        }

        $res = $val - $sum;
        return $res;
    }

    //己算输入值落在那个区间
    function calculateStep($val) {
        $sum = 0;
        for($i=1;$i<10;$i++) {
            $sum += $this->countValue($i);
            if ($sum >= $val) {
                return $i;
            }
        }

        return false;
    }

    //按数学规律求区间能容纳数字的量
    function countValue($n) {
        return $n * pow(10,$n-1) * 9;
    }

    //计算最终值，并返回 ： 相当于str_split函数
    function breakUpVal($val,$t) {
        $res = [];
        $k = 1;
        $flag = false;
        for ($i=10;$i>=0;$i--) {
            if ($val >= pow(10,$i)) {
                $flag = true;
            } 
            if ($flag) {
                $chu = $val / pow(10,$i);
                $res[$k] = intval($chu);
                $k++;
                $val = $val % pow(10,$i);
            }
        }
        if ($t) {
            return $res[$t];
        } else {
            //最后一位是9的特殊情况
            if ($res[$k-1]) {
                return $res[$k-1]-1;
            } else {
                return 9;
            }
        }
        
    }
}