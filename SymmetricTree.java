// Time Complexity : O(n) n nodes in the tree
// Space Complexity : O(height of tree)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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

    //if we draw a line in the middle of the tree, we should be able to fold the tree on itself
    //left subtree should be mirror image of right subtree

    public boolean isSymmetric(TreeNode root) {

        TreeNode left = root.left;
        TreeNode right = root.right;

        return isMirror(left, right);

    }

     public boolean isMirror(TreeNode r1, TreeNode r2) {

        //base cases

        //both null
        if(r1==null && r2==null) return true;

        //only one is null
        if(r1==null || r2==null) return false;

        //roots are not equal
        if(r1.val != r2.val) return false;

        //logic

        //r1's left should match r2's right
        //r1's right should match r2's left
        return isMirror(r1.left, r2.right) && isMirror(r1.right, r2.left);

    }
}
