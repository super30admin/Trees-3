// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(n) where n is the number of nodes in the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class symmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);    
    }
    private boolean helper(TreeNode t1, TreeNode t2) {
        // base case
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        // logic
        return t1.val == t2.val && helper(t1.left, t2.right) && helper(t1.right, t2.left);
    }
}