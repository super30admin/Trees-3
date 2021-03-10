// Time Complexity : O(n)
// Space Complexity : O(n) height of the tree for recursion stack
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
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root.left,root.right);
    }
  
  // Using recursion to check the left of right subtree and right of leftt subtree and the left subtree root value == right subtree root value
  // Also check the edge case, if both the tree is null, if only one is null return false
  
    public boolean symmetric(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        return root1.val == root2.val && symmetric(root1.left,root2.right) && symmetric(root1.right,root2.left);
    }
}
