package leetcode;

public class Solution337 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] res = postRoot(root);
        return Math.max(res[0], res[1]);
    }

    public int[] postRoot(TreeNode cur) {
        if (cur == null) {
            return new int[]{0, 0};
        }
        int[] l = postRoot(cur.left);
        int[] r = postRoot(cur.right);

        int[] res = new int[2];
        res[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        res[1] = l[0] + r[0] + cur.val;
        return res;
    }
}
