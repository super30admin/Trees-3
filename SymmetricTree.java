// Time Complexity : O(n). n is the number of nodes in a tree
// Space Complexity : O(n). 
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return checkSymmetric(root.left,root.right);
    }
    
    private boolean checkSymmetric(TreeNode left,TreeNode right){
        if(left==null && right==null) return true;
        
        if(left==null || right==null || left.val!=right.val) return false;
       return checkSymmetric(left.left,right.right) && checkSymmetric(left.right,right.left);
        
        
        
    }
}
