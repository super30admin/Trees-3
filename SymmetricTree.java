/ Time Complexity : O(n)
// Space Complexity : O(n) and best case : O(logn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
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
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    boolean helper(TreeNode root1, TreeNode root2) {
        // Base case
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        // Action
        if(root1.val != root2.val) return false;
        // Recurse
        return helper(root1.left, root2.right) && helper(root1.right, root2.left);

    }
}