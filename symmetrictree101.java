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
/*
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode r1, TreeNode r2){
        if((r1 != null && r2 == null) ||(r2!=null && r1 == null)) return false;
        if(r1 == null && r2 == null) return true;
        if(r1.val != r2.val) return false;
        return helper(r1.left,r2.right) && helper(r1.right,r2.left);

    }
}
