package com.arthur.leetcode;

import leetcode.Solution735;
import org.junit.Assert;
import org.junit.Test;

/** 
* Solution735 Tester. 
* 
* @author <Authors name> 
* @since <pre>12/08/2019</pre> 
* @version 1.0 
*/ 
public class Solution735Test {
    @Test
    public void testAsteroidCollision() {
        final Solution735 solution = new Solution735();
        int[] asteroids = new int[]{5, 10, -5};
        int[] ret = new int[]{5, 10};
        Assert.assertArrayEquals(solution.asteroidCollision(asteroids), ret);

        int[] asteroids1 = new int[]{8, -8};
        int[] ret1 = new int[]{};
        Assert.assertArrayEquals(solution.asteroidCollision(asteroids1), ret1);

        int[] asteroids2 = new int[]{10, 2, -5};
        int[] ret2 = new int[]{10};
        Assert.assertArrayEquals(solution.asteroidCollision(asteroids2), ret2);

        int[] asteroids3 = new int[]{-2, -1, 1, 2};
        int[] ret3 = new int[]{-2, -1, 1, 2};
        Assert.assertArrayEquals(solution.asteroidCollision(asteroids2), ret2);
    }
} 
