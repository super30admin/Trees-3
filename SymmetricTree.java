public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root, root);
    }

    public boolean isSymmetric(TreeNode v1, TreeNode v2) {
        if (v1 == null && v2 == null)
            return true;

        if (v1 == null || v2 == null)
            return false;

        return (v1.val == v2.val) && isSymmetric(v1.left, v2.right) && isSymmetric(v2.right, v1.left);
    }
}