package test.com.arthur.liang;

import com.arthur.liang.SearchArr;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * SearchArr Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>10/24/2019</pre>
 */
public class SearchArrTest {
    SearchArr sa;

    @Before
    public void before() throws Exception {
        this.sa = new SearchArr();
    }

    @After
    public void after() throws Exception {
        this.sa = null;
    }

    /**
     * Method: search(int[] nums, int target)
     */
    @Test
    public void testSearch() throws Exception {
        Assert.assertEquals(1, this.sa.search(new int[]{1, 3}, 3));

        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        Assert.assertEquals(4, this.sa.search(nums, target));

        int[] nums2 = {4,5,6,7,0,1,2};
        int target2 = 3;
        Assert.assertEquals(-1, this.sa.search(nums2, target2));
        Assert.assertEquals(1, this.sa.search(new int[]{1, 3}, 3));
        Assert.assertEquals(4, this.sa.search(new int[]{4,5,6,7,0,1,2}, 0));
    }

    /**
     *
     * Method: binarySearch(int[] nums, int target, int low, int high)
     *
     */
    @Test
    public void testBinarySearch() throws Exception {
        int[] nums = {0,1,2,4,5,6,7};
        int target = 0;
        Assert.assertEquals(0, this.sa.binarySearch(nums, target, 0, nums.length - 1));
        target = 1;
        Assert.assertEquals(1, this.sa.binarySearch(nums, target, 0, nums.length - 1));
        target = 2;
        Assert.assertEquals(2, this.sa.binarySearch(nums, target, 0, nums.length - 1));
        target = 5;
        Assert.assertEquals(4, this.sa.binarySearch(nums, target, 0, nums.length - 1));
        target = 7;
        Assert.assertEquals(6, this.sa.binarySearch(nums, target, 0, nums.length - 1));
        target = 9;
        Assert.assertEquals(-1, this.sa.binarySearch(nums, target,0, nums.length - 1));
        target = -5;
        Assert.assertEquals(-1, this.sa.binarySearch(nums, target,0, nums.length - 1));

    }


} 
