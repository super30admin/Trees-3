 
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : identifying the base condition


// Your code here along with comments explaining your approach

class Solution {
    public class TreeNode {
             int val;
            TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
   public boolean isSymmetric(TreeNode root) {
       if(root==null) return true;
       return checkSymmetric(root,root);
   }
   private boolean checkSymmetric(TreeNode node1, TreeNode node2)
   {
       // base condition
       if(node1==null && node2==null) return true;
       if(node1==null || node2 == null) return false;
       
       return node1.val==node2.val && checkSymmetric(node1.left,node2.right) && checkSymmetric(node1.right,node2.left);
       
   }
   
  
}