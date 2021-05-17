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

//time- o(n)
//space- o(h)
//passed in leetcode- yes

class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if(root==null) return true;
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right)
    {
            //base
            if(left == null && right==null) //if both are null, return true, symmetric
            {
                return true;
            }
            else if(left==null || right==null)//if one of the childs is null, it should return false, as not symmetric
            {
                return false;
            }
            
            else if(left.val!=right.val)//if children dont match means non symmetric
            {
                return false;
            }
            
        return (
                (helper(left.right,right.left)) && 
                (helper(left.left, right.right))
               );
    }
}