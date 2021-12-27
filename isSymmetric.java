// Time Complexity :O(n)// n is no. of nodes in the tree
// Space Complexity :o(h) //h is the height of the Tree // recursive stack space
// Did this code successfully run on Leetcode 101: yes
// Any problem you faced while coding this :


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
        if (root==null)
            return true;
        return helper(root.left,root.right);
    }
    private boolean helper(TreeNode left,TreeNode right){
        if(left==null && right==null)
            return true;
        if(left==null||right==null||left.val!=right.val)
            return false;
        return helper(left.left,right.right)&& helper(left.right,right.left);
    }
}
