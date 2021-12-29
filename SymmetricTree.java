// Time Complexity :o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public boolean isSymmetric(TreeNode root) {
         
      if(root == null){
          return true;
      }else{
          return isSymeetricTrees(root.left , root.right);
      }
        
    }
    
    private boolean isSymeetricTrees(TreeNode right , TreeNode left){
       
        if(right == null && left == null){
            return true;
        }
      
        if(right == null || left == null) {
               return false;
        }
     
       return right.val == left.val && isSymeetricTrees(right.left ,left.right ) && isSymeetricTrees(right.right, left.left) ;
        
    } 
}