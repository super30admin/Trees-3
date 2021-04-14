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
class Solution101 {
    boolean isValid;
    public boolean isSymmetric(TreeNode root) {
      if(root==null)
      {
          return true;
      }
        isValid=true;
    helper(root.left,root.right);
    return isValid;
    }
    
    private void helper(TreeNode left,TreeNode right){
        if(left==null && right==null)
        {
            return ;
        }
        if(left==null || right==null ||(left.val !=right.val)){
             isValid=false;
            return;
        }
        
        helper(left.left,right.right);
        helper(left.right,right.left);
        
    }
    

}