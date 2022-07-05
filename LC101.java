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

//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
    
    boolean flag;
    
    public boolean isSymmetric(TreeNode root) {
        
        flag = true;
        
        helper(root.left,root.right);
        
        return flag;
    }
    
    private void helper(TreeNode left, TreeNode right)
    {
        //base
        if(left == null && right == null)
        {
            return;
        }
        
        //logic
        
        if(left == null || right == null || left.val!=right.val)
        {
            flag = false;
            return;
        }
        
        helper(left.left,right.right);

        helper(left.right,right.left);
        
        return;
    }
}