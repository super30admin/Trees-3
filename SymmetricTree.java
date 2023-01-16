// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
public class SymmetricTree {
    boolean flag;

    public boolean isSymmetric(TreeNode root) {
        flag = true;
        helper(root.left, root.right);
        return flag;
    }

    private void helper(TreeNode rootLeft, TreeNode rootRight) {
        if (rootLeft == null && rootRight == null) {
            return;
        }
        if (rootLeft == null || rootRight == null) {
            flag = false;
            return;
        }
        if (flag) {
            helper(rootLeft.left, rootRight.right);
        }
        if (rootLeft.val != rootRight.val) {
            flag = false;
        }
        if (flag) {
            helper(rootLeft.right, rootRight.left);
        }
    }
}