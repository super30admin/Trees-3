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
// time complexity 0(n)
// space constant
class Solution {
    boolean isvalid= true;
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        {
            return isvalid;
        }
        helper(root.left,root.right);

        return isvalid;
    }
    private void helper(TreeNode left, TreeNode right)
    {
        if(left == null && right == null)
        {
            return;
        }
        if(left == null || right == null || left.val!= right.val)
        {
            isvalid=false;
            return;
        }
        helper(left.left,right.right);
        helper(left.right,right.left);
    }
}