// Time Complexity : O(n) --> where n is total number of node in the tree
// Space Complexity : O(h) --> where h is the height of the tree
// Did this code successfully run on Leetcode (101): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right) {
        // base case
        if (left == null && right == null) return true;
        // logic
        if (left == null || right == null || left.val != right.val) return false;
        
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}