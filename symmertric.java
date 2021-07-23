//TC: O(n)
//SC: O(1)
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
    boolean result;
    public boolean isSymmetric(TreeNode root) {
        result = true;
        helper(root.left, root.right);
        return result;
    }
    
    private void helper(TreeNode left, TreeNode right) {
        
        if(left == null && right == null) return;
        if(left == null || right == null) {
            result = false;
            return;
        }
        
        
        if(left.val != right.val) {
            result = false;
            return;
        }
        helper(left.left, right.right);
        helper(left.right, right.left);
    }
}