// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        // BFS: can be done with queue - add left and then right
        // DFS:
        if(null == root) return true;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right)
    {
        // base
        if(null == left && null == right) return true;
        if(null == left && null != right) return false;
        if(null == right && null != left) return false;
        if(left.val != right.val) return false;

        // logic
        boolean isLeftValid = dfs(left.left, right.right);
        boolean isRightValid = dfs(left.right, right.left);

        return isLeftValid && isRightValid;
    }
}