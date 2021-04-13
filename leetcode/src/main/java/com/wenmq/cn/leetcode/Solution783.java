package com.wenmq.cn.leetcode;

/**
 * Q783
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 */
public class Solution783 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

//        TreeNode() {
//        }

        TreeNode(int val) {
            this.val = val;
        }

//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
    }

    public int minDiffInBST(TreeNode root) {
        return new SolutionImpl().minDiffInBST(root);
    }

    static class SolutionImpl {
        int pre;
        int ans;

        public int minDiffInBST(TreeNode root) {
            ans = Integer.MAX_VALUE;
            pre = -1;
            dfs(root);
            return ans;
        }

        public void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            //中序遍历先遍历左子树然后是根节点最后是右子树
            dfs(root.left);
            if (pre != -1) {
                ans = Math.min(ans, root.val - pre);
            }
            pre = root.val;
            dfs(root.right);
        }
    }

}
