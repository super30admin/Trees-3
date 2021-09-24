/**
 * Symmetry
 */

public class Symmetry {

    boolean result = true;

    public boolean isSymmetric(TreeNode root) {

        if (root == null)
            return false;
        helper(root.right, root.left);
        return result;
    }

    private void helper(TreeNode left, TreeNode right) {

        if ((left == null) && (right == null))
            return;
        if (left == null || right == null || left.val != right.val) {
            result = false;
            return;
        }

        helper(left.left, right.right);
        helper(left.right, right.left);
    }
}