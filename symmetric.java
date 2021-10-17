//TC:O(height of tree)
//SC:O(1)
//successfully ran on leetcode
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
        if(root == null)
            return true;

        return helper(root.left,root.right);
    }

    public boolean helper(TreeNode N1,TreeNode N2)
    {
        if( N1==null && N2==null)
            return true;

        else if(N1==null || N2==null || N1.val!=N2.val)
            return false;

        return (helper(N1.left,N2.right) && helper(N1.right,N2.left));

    }
}
