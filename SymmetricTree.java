/**
 * Definition for a binary tree node.
 */ 
 
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*Approach
1) check for null cases 
2) and we need to add conditions to end recursion
3) then check left Node of left Node and right node of right node and right Node of left and left node of right (explains the return statement of helper functions)
4) also if the value is not same just return false 
*/



class SymmetricTree {



    public class TreeNode {
        int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
    public boolean isSymmetric(TreeNode root) {
        
        if(root==null)
        {
            return true;
        }
        
        return helper(root.left,root.right);
        
    }
    
    public boolean helper(TreeNode left,TreeNode right)
    {
        if(left==null && right==null)
        {
            return true;
        }
        
        if(left==null || right==null)
        {
            return false;
        }
        
        if(left!=null && right!=null)
        {
            if(left.val!=right.val)
            {
                return false;
            }
        }
        
        
        return helper(left.left,right.right) && helper(left.right,right.left);
        
        
    }
}