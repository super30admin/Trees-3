// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using dfs to traverse the tree on left and right children of a node. We check if left node and right node's values are same, the left's left and right's right children's values are same, the left's right and right's left values are same.
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && dfs(left.right, right.left) && dfs(left.left, right.right);
    }
}