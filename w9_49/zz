class Solution {

    /**
     * @param String[] $strs
     * @return String[][]
     */
    function groupAnagrams($strs) {
        $arr = [
            'a'=>101,
            'b'=>2,
            'c'=>3,
            'd'=>5,
            'e'=>7,
            'f'=>11,
            'g'=>13,
            'h'=>17,
            'i'=>19,
            'j'=>23,
            'k'=>29,
            'l'=>31,
            'm'=>37,
            'n'=>41,
            'o'=>43,
            'p'=>47,
            'q'=>53,
            'r'=>59,
            's'=>61,
            't'=>67,
            'u'=>71,
            'v'=>73,
            'w'=>79,
            'x'=>83,
            'y'=>89,
            'z'=>97
        ];
    $res = [];
    $num =  1;
    foreach($strs as $item){
        $tempArr = array_filter(explode(" ",chunk_split($item,1," ")));
            $tempX = 1;
            foreach($tempArr as $k=>$v){
                $tempX *= $arr[$tempArr[$k]];
            }
            if(!isset($res[$tempX])){
                $res[$tempX] = [];
            }
            //$res[$tempX][] = $item;
            array_push($res[$tempX],$item);
            
    }
    return $res;
    }
}
