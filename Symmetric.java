// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//We are calling recursion on left and right subtree, and then we are checking if left child of left node is equal to
//right child of right node and then right child of left node is equal to left child of right node then we return true 
//else we riturn false

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
        if(root==null){
            return true;
        }
        
        return recurr(root.left,root.right);
    }
    
    private boolean recurr(TreeNode n1,TreeNode n2){
        if(n1 == null && n2==null){
            return true;
        }
        if(n1==null || n2==null || n1.val!=n2.val){
            return false;
        }
        
        return recurr(n1.left,n2.right) && recurr(n1.right,n2.left);
    }
}