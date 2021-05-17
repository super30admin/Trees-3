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
    //Time O(N)
    //Space O(H)
    boolean isValid;
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
        {
            return true;
        }
        return helper(root.left , root.right);
    }
    public boolean helper(TreeNode Left, TreeNode Right)
    {
        //base
        //Logic
        if(Left == null && Right == null)
        {
            return true;
        }
        if((Left == null || Right == null) ||(Left.val != Right.val))
        {
            return false;
        }
        return helper(Left.left, Right.right) && helper(Left.right, Right.left);
    }
}