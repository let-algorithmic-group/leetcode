/*
 * @lc app=leetcode.cn id=207 lang=php
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {

    /**
     * @param Integer $numCourses
     * @param Integer[][] $prerequisites
     * @return Boolean
     */
    function canFinish($numCourses, $prerequisites) {
        $hash = [];
        $mark = [];
        $default = [];

        foreach ($prerequisites as $item) {
            $hash[$item[0]][] = $item[1];
            $mark[$item[0]] = 0;
            $default[$item[0]] = 0;
        }

        for ($i = 0; $i < $numCourses; $i++) {
            $mark = $default;
            if ($this->trace($i, $hash, $i, $mark)) {
                return false;
            }
        }

        return true;
    }

    function trace($i, $hash, $target, &$mark) {
        if (!isset($hash[$i])) {
            return false;
        }
        if ($mark[$i] == 1) {
            return false;
        }
        $mark[$i] = 1;

        if (in_array($target, $hash[$i])) {
            return true;
        } else {
            foreach ($hash[$i] as $next) {
                if ($this->trace($next, $hash, $target, $mark)) {
                    return true;
                }
            }
        }
    }
}
