// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if (root == null) return true;
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right) {
        //Base case
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        
        
        
        //Logic
        return helper(left.left,right.right) && helper(left.right,right.left);
    }
}