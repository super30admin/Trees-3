// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class SymmetricTreeDFSBooleanBasedRecursion {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        // base
        if (left == null && right == null) return true;
        if(left == null || right == null || left.val != right.val) {
            return false;
        }

        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
