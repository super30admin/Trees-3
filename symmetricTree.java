// Time Complexity : O(N) where N number of nodes
// Space Complexity : O(H) where H is height of the tree
// Did this code successfully run on Leetcode : Yes	
// Any problem you faced while coding this : No


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
    private boolean helper(TreeNode root1, TreeNode root2)
    {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        return (root1.val == root2.val) && helper(root1.left,root2.right) && helper(root1.right, root2.left);
    }
    
    public boolean isSymmetric(TreeNode root) {
        return helper (root , root);
    }
}