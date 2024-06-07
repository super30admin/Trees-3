/***
 Approach - Using recursive DFS
 1. First check if root is null, return true, otherwise call recursive function on root.left and root.right
 2. If root.left and root.right both are null, return true, else if one of them is null, return false, else if(left.val != right.val), return false
 3. Call recursion on (left.left, right.right) and (left.right, right.left)
 TC - O(n), SC - O(h)
 */

class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if(left == null && right == null)
            return true;

        if(left == null || right == null)
            return false;

        if(left.val != right.val)
            return false;

        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        int val;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}