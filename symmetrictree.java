// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// A tree is symmetric if the leftsubtree's left is equal to right subtree's right and  leftsubtree's right is equal to right subtree's left.
// here we are calling a helper function on root.left and root.right
// if both the n1 and n2 are null return true
// if either one is null then it is not symmetric so return false
// the values of n1 and n2 must be equal and n1.left, n2.right and n1.right and n2.left must be symmetric.

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
        return helper(root.left,root.right);
    }
    private boolean helper(TreeNode n1, TreeNode n2)
    {

        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }

        return (n1.val==n2.val && helper(n1.left,n2.right) && helper(n1.right,n2.left));
    }
}