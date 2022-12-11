public class Leetcode101 {
    boolean isSymmetric;

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        isSymmetric = true;

        dfs(root.left, root.right);

        return isSymmetric;
    }

    public void dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return;

        // this is to check ifthere is a symmtry between both left and right side of the
        // tree
        // if there is any mismatch then the tree can not be symmetric
        if (left == null || right == null || left.val != right.val) {
            isSymmetric = false;
            return;
        }

        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}

// tc--> O(n)
// sc--> O(h)
