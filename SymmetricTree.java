package Nov29;

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
class SymmetricTree {
    
    /*
    Time Complexity: O(n/2) ~= O(n) because we are taking n/2 steps to traverse through all n nodes of the tree
    
    Space Complexity: Recursive stack space will be O(h) where h is height of the tree
    
    Approach used:
    Recursive approach used.
    */
    
    public boolean isSymmetric(TreeNode root) {
        
        // edge
        if (root == null) {
            return true;
        }
        
        return helper(root.left, root.right);
    }
    
    // helper function for handling the core logic recursively
    private boolean helper(TreeNode left, TreeNode right) {
        
        //base
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        
        //logic
        return helper(left.left, right.right) && helper(left.right, right.left);
        
    }
}