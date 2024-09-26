class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return recurse(root, root);
    }

    private boolean recurse(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;

        return (node1.val == node2.val) && recurse(node1.right, node2.left)
                && recurse(node1.left, node2.right);
    }
}