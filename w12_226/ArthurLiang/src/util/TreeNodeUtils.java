package leetcode.util;

import leetcode.entity.TreeNode;

public class TreeNodeUtils {
    public static boolean isSameTree(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null && treeNode2 == null) {
            return true;
        } else if (treeNode1 == null || treeNode2 == null) {
            return false;
        } else {
            if (treeNode1.val != treeNode2.val) {
                return false;
            } else {
                return isSameTree(treeNode1.left, treeNode2.left) && isSameTree(treeNode1.right, treeNode2.right);
            }
        }
    }
}
