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
//Time Complexity: O(n)
//Space Complexity: O(n)    
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return helper(root, root);
    }
    private boolean helper(TreeNode right, TreeNode left){
        if(right==null && left==null) return true;
        if(right==null || left==null) return false;
        if(right.val!=left.val) return false;
        return helper(right.left,left.right) && helper(right.right,left.left);
    }
}