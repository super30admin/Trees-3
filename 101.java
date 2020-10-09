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

/**
SC : O(H) avg case and O(n) skewed tree
TC: O(n)
**/


// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        
        return helper(root.left, root.right);
    }
    
    
    private boolean helper(TreeNode p1, TreeNode p2){
        if(p1 == null && p2 == null)
            return true;
        
        if(p1 == null || p2 == null || p1.val != p2.val)
            return false;
        
        return helper(p1.left, p2.right) && helper(p1.right, p2.left);
    }
    
}