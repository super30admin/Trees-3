// Time Complexity : O(n)
// Space Complexity : O(height of tree)
// Did this code successfully run on Leetcode : Yes

public class SymmetricTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private boolean helper(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;

        return helper(p.left, q.right) && helper(p.right,q.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
}
