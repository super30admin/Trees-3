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
    boolean flag;
   public boolean hasPathSum(TreeNode root, int targetSum) {
       this.flag=false;
       helper( root,targetSum,0);
       return flag;
       
   }
   public void helper(TreeNode root,int targetSum,int curr){
      if(root == null)return;
     curr += root.val;
     if(root.left == null && root.right == null){
       if(targetSum == curr){
           flag=true;
       };
      
     }
     helper(root.left,targetSum,curr);
     helper(root.right,targetSum,curr);
   }

}