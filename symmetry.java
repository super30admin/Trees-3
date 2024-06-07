// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    boolean isSymmetry; // globally defining symmetry variable
    public boolean isSymmetric(TreeNode root) {
        isSymmetry = true;
        dfs(root.left, root.right); // passing left and right nodes
        return isSymmetry;
    }
    private void dfs(TreeNode left, TreeNode right){
        if(left == null && right == null){ // no elements
            return;
        }
        if(left == null || right == null){ // one of them is null, hence already unequal
            isSymmetry = false;
            return;
        }
        if(left.val != right.val){ // values are not equal
            isSymmetry = false;
            return;
        }
        dfs(left.left, right.right); // traverse left end and right end
        dfs(left.right, right.left); // opposite of left and right ends
    }
}