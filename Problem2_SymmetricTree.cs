// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public bool IsSymmetric(TreeNode root) {
        return CheckSymmetry(root.left, root.right);
    }

    private bool CheckSymmetry(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;

        if (left == null || right == null || left.val != right.val) return false;
 
        return CheckSymmetry(left.left, right.right) && CheckSymmetry(left.right, right.left);
    }
}