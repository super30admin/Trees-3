/* Time Complexity :  O(n) where n is number of nodes
   Space Complexity : O(h) h is recursion stack space equal to height of tree
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode l,TreeNode r){  
         if(l==null && r==null)
            return true;
        if(l==null || r==null)
            return false; 
         if(l.val!=r.val){
            return false;
        }
        return helper(l.left,r.right) && helper(l.right,r.left);
    }
}