package com.arthur;

import org.junit.Assert;
import org.junit.Test;

public class Solution136Test {

    @Test
    public void testSingleNumber() {
        int[] nums = {2, 2, 1};
        final Solution136 solution136 = new Solution136();
        Assert.assertEquals(solution136.singleNumber(nums), 1);

        int[] nums1 = new int[]{4, 1, 2, 1, 2};
        Assert.assertEquals(solution136.singleNumber(nums1), 4);
    }

    @Test
    public void testSingleNumber1() {
        int[] nums = {2, 2, 1};
        final Solution136 solution136 = new Solution136();
        int i  = solution136.singleNumber1(nums);
        Assert.assertEquals(i, 1);

        int[] nums1 = new int[]{4, 1, 2, 1, 2};
        Assert.assertEquals(solution136.singleNumber1(nums1), 4);
    }

    @Test
    public void testSingleNumber2() {
        final Solution136 solution136 = new Solution136();
        /*int[] nums = {2, 2, 1};
        int i  = solution136.singleNumber2(nums);
        Assert.assertEquals(i, 1);*/

        int[] nums1 = new int[]{4, 1, 2, 1, 2};
        Assert.assertEquals(solution136.singleNumber2(nums1), 4);
    }
}
