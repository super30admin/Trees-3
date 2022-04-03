// Time Complexity : O(nodes)
// Space Complexity : O(nodes)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : N


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
    boolean flag = false;
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        flag = true;
        check_sym(root.left, root.right);
        return flag;
    }
    private void check_sym(TreeNode left, TreeNode right)
    {
        
        if(left==null && right==null)
        {
            return;
        }
        if(left==null || right==null || left.val!=right.val)
        {
            flag = false;
            return;
        }
        check_sym(left.left, right.right);
        check_sym(left.right, right.left);
    }
}








