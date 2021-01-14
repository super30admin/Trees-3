// Time Complexity : O(n)
// Space Complexity : O(h) h is height of tree
// Did this code successfully run on Leetcode : Yes

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
    boolean isValid;
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        isValid = true;
        helper(root.left, root.right);
        return isValid;
    }
    private void helper(TreeNode left, TreeNode right){
        //base
        if(left == null && right == null)
            return;
        //logic
        if(left == null || right == null || left.val != right.val){
            isValid = false;
            return;
        }
        helper(left.left, right.right);
        helper(left.right, right.left);
        return;
    }
}