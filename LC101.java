// TC: O(N)
// SC: O(N) for recursive stack (in the worst case).

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

public class LC101 {
    private boolean recurse(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.val != root2.val)
            return false;

        boolean case1 = recurse(root1.left, root2.right);
        boolean case2 = recurse(root1.right, root2.left);

        return case1 && case2;

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return recurse(root.left, root.right);
    }
}