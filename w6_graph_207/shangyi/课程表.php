class Solution {

    /**
     * @param Integer $numCourses
     * @param Integer[][] $prerequisites
     * @return Boolean
     */
    function canFinish($numCourses, $prerequisites) {
        $p = [];

        for ($i=0;$i<$numCourses;$i++) {
            $p[$i]['num'] = 0;
            $p[$i]['val'] = [];
        }

        $num = count($prerequisites);
        $number = $num >= $numCourses ? $num : $numCourses;

        for ($j=0;$j<$number;$j++) {
            $p[$prerequisites[$j][1]]['num']++;
            $p[$prerequisites[$j][1]]['val'][] = $prerequisites[$j][0];
        }
        
        return $this->achieveData($p);
    }
    
    function achieveData($arr) {
		$r = [1];
		while (count($arr) >0 && $r) {
			$r = [];
			foreach ($arr as $key => $value) {	
				if ($value['num'] == 0) {
					unset($arr[$key]);
					$r[] = $key;
				}
			}	
            
			if ($r) {
				foreach ($arr as $k => $val) {
					foreach ($val['val'] as $kk => $v) {
						if (in_array($v, $r)) {
							$arr[$k]['num']--;	
							unset($arr[$k]['val'][$kk]);
						}
					}
				}
			}
		}

		if ($arr) {
			return false;
		} else {
			return true;
		}

	}
}