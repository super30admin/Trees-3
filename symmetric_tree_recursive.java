// Time Complexity : O(n) 
// Space Complexity : O(h) : in worst case it is upto O(n)

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
        
        // Empty node
        if (root == null){
            return false;
        }
        
        // Recursive approach
        return helper(root.left, root.right);
       
        
    }
    
    private boolean helper (TreeNode left, TreeNode right){
        
        // leaf node (single node itself is symmetric)
        if ( left == null && right == null){
            return true;
        }
        
        // root has only one child (either left or right sub tree)
        if (left == null || right == null){
            return false;
        }
        
        // Value of left must be equal to value of right
        if (left.val != right.val){
            return false;
        }
        
        boolean outside = helper(left.left, right.right);
        
        boolean inside = helper(left.right, right.left);
        
        return outside & inside;
    }
}