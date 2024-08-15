// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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
        // An empty tree is symmetric
        if (root == null) {
            return true;
        }
        // Check if left and right subtrees are mirrors of each other
        return isMirror(root.left, root.right);
    }
    
    // Helper method to determine if two trees are mirrors of each other
    private boolean isMirror(TreeNode left, TreeNode right) {
        // Both nodes are null, trees are mirrors
        if (left == null && right == null) {
            return true;
        }
        // One node is null but not the other, not mirrors
        if (left == null || right == null) {
            return false;
        }
        // Both nodes are non-null, check values and recursively check subtrees
        return (left.val == right.val) // Check current node values
            && isMirror(left.right, right.left) // Recursively check right subtree of left and left subtree of right
            && isMirror(left.left, right.right); // Recursively check left subtree of left and right subtree of right
    }

}
