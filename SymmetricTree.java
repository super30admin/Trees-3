//Time Complexity- O(n)
//Space Complexity- O(h)
//Successfully ran on leetcode

class Solution {
 boolean isValid;
 public boolean isSymmetric(TreeNode root) {
    
     if(root==null) return true;
     isValid= true;
     
     helper(root.left, root.right);
     return isValid;
 }

 private void helper(TreeNode left, TreeNode right){
    
     if(left== null && right== null) return;
     if(left==null || right== null || left.val!= right.val){
         isValid= false;
         return;
     }
     helper(left.left, right.right);
     helper(left.right, right.left);
 }
}