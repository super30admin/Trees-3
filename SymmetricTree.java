// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * we do an inorder traversal and for each of the left and right subtree, we compare their left element with right element of the other subtree.
 * If we find a mismatch, we return false.
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        // we always have a root node
        
        // maintain two pointers for left subtree and right subtree
        TreeNode left_subtree = root.left;
        TreeNode right_subtree = root.right;
        
        return helper(left_subtree, right_subtree);
    }
    
    private boolean helper(TreeNode left_sub, TreeNode right_sub) {
        
        if(left_sub == null && right_sub == null) {
            return true;
        } else if(left_sub == null || right_sub == null) {
            return false;
        }
        
        if(left_sub.val != right_sub.val) {
            return false;
        } 
        
        boolean left_res = helper(left_sub.left, right_sub.right);
        
        boolean right_res = helper(left_sub.right, right_sub.left);
        
        return left_res && right_res;
    }
}