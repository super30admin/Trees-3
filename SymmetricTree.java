/*
 * TC: O(n) recursing thorugh all the nodes.
 * SC: O(n) for recursive stack. worst case O(n) because if  worst case if the tree is skewed.
 * 
 * Approach: i will keep checking if my root.left value = root.right value && root.right = root.left
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
        return helper(root, root);
    }

    private boolean helper(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;

        return root1.val == root2.val && helper(root1.left,root2.right) && helper(root1.right, root2.left); 
    }
}