class TreeNode {
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

public class SymmetricTree {

    // TC: O(n) n - number of nodes in a tree
    // SC: O(h) h - height of the tree. Because at a time,
    // we will be putting either left.left and right.right OR  left.right and right.left in the stack
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;

        if(left == null || right == null || left.val != right.val) return false;

        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
