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
    // Function to check if a binary tree is symmetric
    public boolean isSymmetric(TreeNode root) {
        if(root==null)  // If the root is null, it is symmetric
            return true;
        
        return dfs(root.left, root.right);
    }

    // Helper function for depth-first search to check symmetry
    private boolean dfs(TreeNode left, TreeNode right) {
        // If both nodes are null, they are symmetric
        if (left == null && right == null)
            return true;

        // If only one of the nodes is null, they are not symmetric
        if (left == null || right == null)
            return false;

        // If the values of the nodes are not equal, they are not symmetric
        if (left.val != right.val)
            return false;

        // Recur for the left subtree's left and the right subtree's right, and vice versa
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}

// Time Complexity: O(N) - where N is the number of nodes in the binary tree
// Space Complexity: O(h) - where h is the height of the binary tree
