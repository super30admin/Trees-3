// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : Traversal the left and right subtrees simultaneously and check if corresponding nodes are same

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
        if(root==null){
            return true;
        }
        return helper(root.left, root.right);
    }
    public boolean helper(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }
        else if(left==null || right==null || left.val!=right.val){
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}