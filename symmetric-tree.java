import java.util.*;

//TC is O(n)
//SC is O(h) = O(log n)
class Solution {
    public boolean isSymmetric(TreeNode root) {

        return dfs(root.left, root.right);

    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        return dfs(left.right, right.left) && dfs(left.left, right.right);
    }
}