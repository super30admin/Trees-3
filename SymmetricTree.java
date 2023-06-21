// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to refer to BFS and DFS discussion from class



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
class Solution {
    private boolean flag;
    public boolean isSymmetric(TreeNode root) {
        flag = true;
        helper(root.left,root.right);
        return flag;
    }

    private void helper(TreeNode left, TreeNode right){
        // base case
        if(left == null && right == null) return;
        // If one of the left or right is null or else right not equal to right then it is a fail case so set flag as false
        if(left == null || right == null || left.val != right.val) {
            flag = false;
            return;
        }
        // this if conditions are for making it conditional void based recursion
        if(flag)
            helper(left.left,right.right);
        if(flag)
            helper(left.right,right.left);
    }
}