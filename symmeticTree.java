// Problem2 (https://leetcode.com/problems/symmetric-tree/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/* 
 * Here, helper function is used with root.left and root.right. Recursive calls for left and right are used. For left, pass left.left and
 * right.right. For right recursive call, pass left.right and right.left. If left and right are null return true. If either one is null return
 * false. These are base conditions. Move until left!= right. Left and right says about the symmetry.
 */

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
    /* recursion approach */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val){
            return false;
        }
        boolean l = helper(left.left, right.right);
        boolean r = helper(left.right, right.left);
        return l && r;
    }

}