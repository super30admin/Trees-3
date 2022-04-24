/**
Problem: https://leetcode.com/problems/path-sum-ii/
TC:O (n) where n is the total number of nodes in the tree.
SC: o(1)
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
        
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        
        if (left == null || right == null) 
            return false;
        
        return (left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left));
    }
}