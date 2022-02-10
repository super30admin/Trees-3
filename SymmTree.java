public class SymmTree {
    public boolean symmTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        boolean outside = helper(left.left, right.right);
        boolean inside = helper(left.right, right.left);
        return outside && inside;

    }

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
}
