public class SymmetricTree {
    // Time Complexity : O(n)
    // Space Complexity : O(h)
    // Did this code successfully run on Leetcode : yes
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null) return false;
        if (leftNode.val != rightNode.val) return false;

        return helper(leftNode.left, rightNode.right) && helper(leftNode.right, rightNode.left);
    }
}