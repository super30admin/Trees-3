// TC : O(n)
// SC : O(1)
// Approach : Mirror Tree Comparison by comparing left and right subtrees i.e., left.left with right.right and left.right with right.left
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
    boolean flag = true;

    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        helper(root.left, root.right);
        return flag;

    }

    private void helper(TreeNode left, TreeNode right) {
        // Base
        if (right == null && left == null) {
            return;
        }

        // Logic
        if (right == null || left == null || right.val != left.val) {
            flag = false;
            return;
        }

        // Left
        if (flag) {
            helper(left.left, right.right);
        }

        // Right
        if (flag) {
            helper(left.right, right.left);
        }
    }
}