// 101. Symmetric Tree
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

 /*
 TC: O(n)
 SC: O(h)
 Traverse to left of left subtree and right of right subtree and Traverse to right of left subtree and left of right subtree and check if the values are different
 */
class Solution {

    private boolean flag;

    public boolean isSymmetric(TreeNode root) {
        this.flag = true;
        if(root == null) return false;
        // check if the left subtree and right subtree are symmetric
        helper(root.left, root.right);
        return flag;
    }

    private void helper(TreeNode left, TreeNode right){
        // if both are null return
        if(left == null && right == null) return;

        // if one of them is null then turn the flag to false
        if(left == null || right == null){
            flag = false;
            return;
        }

        // if the values are different in left and right subtree then turn the flag to false
        if(left.val != right.val) flag = false;

        // Traverse to left of left subtree and right of right subtree
        if(flag) helper(left.left, right.right);
        
        // Traverse to right of left subtree and left of right subtree
        if(flag) helper(left.right, right.left);
        
    }
}