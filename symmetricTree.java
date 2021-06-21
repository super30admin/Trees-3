// Time Complexity: O(n)
// Sapce Complexity: O(Edge)
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
    boolean result = true;
    public boolean isSymmetric(TreeNode root) {
        helper(root.left, root.right);
        return result;
    }
    public void helper(TreeNode leftRoot, TreeNode rightRoot){
        if(leftRoot == null && rightRoot == null) return;
        if(result == false) return;
        if(leftRoot != null && rightRoot != null && leftRoot.val == rightRoot.val){
            result = true;
            helper(leftRoot.left, rightRoot.right);
            helper(leftRoot.right, rightRoot.left); 
        } 
        else result = false;
        
    }
}