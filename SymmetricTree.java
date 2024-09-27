// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :Yes

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    boolean flag;

    public boolean isSymmetric(TreeNode root) {
        flag = true;
        dfs(root.left, root.right);
        return flag;
    }

    private void dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return;
        if (left == null || right == null || left.val != right.val) {
            flag = false;
            return;
        }
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}