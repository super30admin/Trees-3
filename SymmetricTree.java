//tc : O(n)
//sc : O(height of tree); recursion stack

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null || r1.val != r2.val )
            return false;

        return helper(r1.left, r2.right) && helper(r2.left, r1.right);
    }
}