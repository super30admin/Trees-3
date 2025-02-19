// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class SymmetricTreeDFSVoidBasedRecursion {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        this.flag = true;
        dfs(root.left, root.right);
        return flag;
    }

    private void dfs(TreeNode left, TreeNode right) {
        // base
        if (!flag) return;
        if (left == null && right == null) return;
        if(left == null || right == null || left.val != right.val) {
            flag = false;
            return;
        }

        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}
