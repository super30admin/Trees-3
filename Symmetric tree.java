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
//Time complexity: O(n)
//Space complexity: O(h)
class Solution {
    boolean res=true; int t=0;
    public boolean isSymmetric(TreeNode root) {
         helper(root.left,root.right);
        return res;
    }
    public void helper(TreeNode left, TreeNode right)
    {
       
        if(left==null && right==null)
        {
            res= true;
            return;
        }
        if(left!=null && right==null)
        {
            res= false;
            return;
        }
        if(left==null && right!=null)
        {
            res= false;
            return;
        }
        if(left.val != right.val)
        {
            res= false;
            return;
        }
        
      if(res==true) helper(left.left, right.right);
      if(res==true)  helper(left.right , right.left);
      
    }
}