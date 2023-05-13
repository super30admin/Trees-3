// Time Complexity : O(n) where n is number of nodes in tree
// Space Complexity : O(h) for recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*
 * Approach:
 * We keep traversing the tree on both sides using DFS till each leaf, all the
 * while checking whether any element is not matching on either side.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private boolean isSymmetric;
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }

        isSymmetric = true;
        dfs(root.left, root.right);
        return isSymmetric;
    }

    private void dfs(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return;
        }
        
        // already checked for both being null, so if either is null, 
        // it's not symmetric
        if(left == null || right == null) {
            isSymmetric = false;
            return;
        }

        // next check for value symmetry
        if(left.val != right.val) {
            isSymmetric = false;
            return;
        }

        dfs(left.left, right.right);
        dfs(right.left, left.right);
    }
}