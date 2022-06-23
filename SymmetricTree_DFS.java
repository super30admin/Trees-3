/* Time Complexity: O(n)
 * Space Complexity: O(h), h is the height of the tree, recursive stack space
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 */

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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }
    private boolean dfs(TreeNode left, TreeNode right){
        //base
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val != right.val) return false;
        //logic
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}