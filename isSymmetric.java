// Time Complexity : O(N)
// Space Complexity : O(h) where h is height
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


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
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode left, TreeNode right){
        //check if the left and right value are null or not
        if(left == null && right == null)
            return true;
        //if left value is not equal to the right value
        if(left == null || right == null || left.val != right.val){
            return false;
        }
        //again iterate as left of left and right of right and right of left and left of right
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}