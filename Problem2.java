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

// Time Complexity : (N)
// Space Complexity : O(max(depth))
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
    iterate in preorder until not nodes are equal, they else are equal

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;

        if(root.left==null && root.right==null)
            return true;

        return helper(root.left,root.right);
    }

    public boolean helper(TreeNode leftChild, TreeNode rightChild){
        if(leftChild==null && rightChild==null)
            return true;

        if(leftChild==null || rightChild==null)
            return false;

        if(leftChild.val!=rightChild.val)
            return false;

        return (helper(leftChild.left,rightChild.right) && helper(leftChild.right, rightChild.left));
    }
}