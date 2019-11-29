package com.arthur.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import leetcode.Solution394;

public class Solution394Test {
    @Test
    public void testSolution() {
        Solution394 solution = new Solution394();
        String input1 = "3[a]2[bc]";
        String input2 = "3[a2[c]]";
        String input3 = "100[leetcode]";
        String input4 = "2[a1[cd]]";
        String input5 = "2[2[2[a]]]";

        assertEquals(solution.decodeString(input1), "aaabcbc");
        assertEquals(solution.decodeString(input2), "accaccacc");
        assertEquals(solution.decodeString(input3), "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode");
        assertEquals(solution.decodeString(input4), "acdacd");
        assertEquals(solution.decodeString(input5), "aaaaaaaa");
    }
}