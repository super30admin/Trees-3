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
    // Time Complexity : O(n), where n is no of nodes in the tree
    // Space Complexity : O(h), where h is the height of the tree
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode root1, TreeNode root2) {
        if(null == root1 && null != root2) {
            return false;
        }
        if(null != root1 && null == root2) {
            return false;
        }
        if(null != root1 && null != root2 && root1.val != root2.val) {
            return false;
        }
        if(null == root1 && null == root2) {
            return true;
        }
        return isSymmetricHelper(root1.left, root2.right) && isSymmetricHelper(root1.right, root2.left);
    }
}