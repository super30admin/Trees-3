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

 //  Tc: O(n), sc:O(h)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left,root.right);
    }

    private boolean helper(TreeNode t1, TreeNode t2){
        if(t1==null && t2==null) return true;

        if(t1==null || t2==null) return false;

        if(t1.val != t2.val) return false;

        return helper(t1.left, t2.right) && helper(t1.right,t2.left);
    }
}