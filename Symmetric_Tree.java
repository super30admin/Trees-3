// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {

    private boolean helper(TreeNode p, TreeNode q) {

        if (p == null || q == null) return p == q;

        // Compare Values and Move in each other Mirror Direction
        // Left -> Right
        // Right <- Left
        return p.val == q.val && helper(p.left, q.right) && helper(p.right, q.left);

    }

    public boolean isSymmetric(TreeNode root) {

        if (root == null) return true;

        // split the tree into two parts and move simultenuously

        return helper(root.left, root.right);

    }
}