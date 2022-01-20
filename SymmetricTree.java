//time complexity:O(n)
//space complexity:O(height)

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
        if(root==null)
            return true;
        return helper(root.left,root.right);
    }
    private boolean helper(TreeNode left, TreeNode right){
        
        //base
        if(left==null && right==null)
            return true;
        if(left!=null && right==null)
            return false;
        if(left==null && right!=null)
            return false;
        if(left.val != right.val)
            return false;
        //logic
        return helper(left.left,right.right) && helper(left.right,right.left);
    }
}
