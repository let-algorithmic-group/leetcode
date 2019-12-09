package leetcode;

import leetcode.entity.TreeNode;
import leetcode.util.TreeNodeUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Solution226 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>12月 9, 2019</pre>
 */
public class Solution226Test {

    /**
     * Method: invertTree(TreeNode root)
     */
    @Test
    public void testInvertTree() throws Exception {

        TreeNode rootLeftLeft = new TreeNode(1);
        TreeNode rootLeftRight = new TreeNode(3);
        TreeNode rootLeft = new TreeNode(2);
        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootLeftRight;


        TreeNode rootRightLeft = new TreeNode(6);
        TreeNode rootRightRight = new TreeNode(9);
        TreeNode rootRight = new TreeNode(7);
        rootRight.left = rootRightLeft;
        rootRight.right = rootRightRight;

        TreeNode root = new TreeNode(4);
        root.left = rootLeft;
        root.right = rootRight;

        Solution226 solution = new Solution226();
        TreeNode resTree = solution.invertTree(root);

        TreeNode reverseRootLeftLeft = new TreeNode(9);
        TreeNode reverseRootLeftRight = new TreeNode(6);
        TreeNode reverseRootLeft = new TreeNode(7);
        reverseRootLeft.left = reverseRootLeftLeft;
        reverseRootLeft.right = reverseRootLeftRight;


        TreeNode reverseRootRightLeft = new TreeNode(3);
        TreeNode reverseRootRightRight = new TreeNode(1);
        TreeNode reverseRootRight = new TreeNode(2);
        reverseRootRight.left = reverseRootRightLeft;
        reverseRootRight.right = reverseRootRightRight;

        TreeNode reverseRoot = new TreeNode(4);
        reverseRoot.left = reverseRootLeft;
        reverseRoot.right = reverseRootRight;

        Assert.assertTrue(TreeNodeUtils.isSameTree(resTree, reverseRoot));
    }


} 
