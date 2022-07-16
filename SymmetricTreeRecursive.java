//Time complexity :O(n)
//Space Complexity:O(h)
//Facebook Interview
//Recursive Solution:Here we will be checking for left child for left child of a root node and right child of right child of root node and vice versa if they are equal or not . if not that means the tree is not mirror image else it is. we will keep on checking till we are not at null node.

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
        if(root == null) return true;
        return helper(root.left,root.right); 
    }
    private boolean helper(TreeNode left,TreeNode right){
      //base
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val!=right.val) return false;
        return helper(left.left,right.right) && helper(left.right,right.left); 
    }       
}