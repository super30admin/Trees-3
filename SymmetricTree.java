
public class SymmetricTree {
    boolean isSymmetric;

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        isSymmetric = true;
        dfs(root.left, root.right);
        return isSymmetric;
    }

    private void dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return;
        if (left == null || right == null) {
            isSymmetric = false;
            return;
        }

        if (left.val != right.val) {
            isSymmetric = false;
            return;
        }
        dfs(left.left, right.right);
        dfs(left.right, right.left);

    }
}
