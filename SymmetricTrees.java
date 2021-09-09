// TIME: O(n)
// SPACE: O(n)
// SUCCESS on LeetCode


public class SymmetricTrees {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    
    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && helper(left.right, right.left) && helper(left.left, right.right);
    }
}
