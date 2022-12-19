public class Symmetric_Tree {

    // Time: O(n), Space: O(n)
    public boolean isSymmetric(TreeNode root) {
        return isSame(root, root);
    }

    boolean isSame(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;

        return (r1.val == r2.val) && isSame(r1.left, r2.right) && isSame(r1.right, r2.left);
    }
}
