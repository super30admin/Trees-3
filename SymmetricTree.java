// Time Complexity : O(N)
// Space Complexity : O(N) - stack space
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
class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    private boolean helper(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;

        if(t1 == null || t2 == null) return false;

        return (t1.val == t2.val)
                && helper(t1.right, t2.left)
                && helper(t1.left, t2.right);
    }
}