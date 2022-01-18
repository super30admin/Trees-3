public class SymmetricRecursive {

    // TC O(N)
    // SC O(h) - where h is height of tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode right, TreeNode left) {
        if (right == null && left == null) {
            return true;
        }
        if ((right == null && left != null) || (right != null && left == null)) {
            return false;
        }
        if (right.val != left.val) {
            return false;
        }
        return helper(right.right, left.left) && helper(right.left, left.right);
    }
}
