// Problem 101. Symmetric Tree
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        // null tree is symmetric
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode left, TreeNode right) {
        // base
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val) && helper(left.left, right.right) && helper(left.right, right.left);
    }
}
