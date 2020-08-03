//Time Complexity: O(n) each node is visited once in the traversal
//space complexity: O(height of the tree)
//approach: a tree is symmetric: if the left child of root of left subtree is equal to the right child of the root of right subtree && if the right child of the root of the left subtree is equal to the left child of the root of the right subtree




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
        return helper(root.left,root.right);
    }
    public boolean helper(TreeNode left,TreeNode right)
    {
        if(left==null && right==null) return true;
        if(left==null && right!=null || left!=null && right==null || left.val!=right.val) return false;
        return helper(left.left,right.right) && helper(left.right,right.left);
    }
}