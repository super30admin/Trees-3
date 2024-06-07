// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    boolean isSymmetric;
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        isSymmetric = true;
        dfs(root.left, root.right);
        return isSymmetric;
    }

    private void dfs(TreeNode left, TreeNode right){
        if(left == null && right == null ){
            return;
            //return true;
        }

        if(left == null || right == null){
            isSymmetric = false;
            return;
            //return false;
        }

        if(left.val != right.val){
            isSymmetric = false;
            return;
            //return false;
        }

        dfs(left.left, right.right);
        dfs(left.right, right.left);
       //return (dfs(left.left, right.right) && dfs(left.right, right.left));
    }
}