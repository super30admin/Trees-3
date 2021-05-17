// Time complexity - O(n)
// Space complexity - O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
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
    boolean globalBoolean = true;
    public boolean isSymmetric(TreeNode root) {
        
        helper(root.left,root.right);
        return globalBoolean;
    }
    
    private void helper(TreeNode rootLeft,TreeNode rootRight){
        
        if(rootLeft == null && rootRight == null){
            
            
             return;
        }
        
        
         if(rootLeft == null && rootRight != null){
            
             globalBoolean = false;
             return;
        }
        
        if(rootLeft != null && rootRight == null){
            
             globalBoolean = false;
             return;
        }
        
        if(rootLeft.val != rootRight.val){
            
            globalBoolean = false;
            return;
        }
        
        helper(rootLeft.left,rootRight.right);
        helper(rootLeft.right,rootRight.left);
        
    }
}