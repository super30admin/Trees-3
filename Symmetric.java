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
 time complexity : O(n)
 Space complexity : O(1)
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return bal(root.left,root.right);
    }
    private boolean bal(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        
        if(left == null || right == null || left.val != right.val)return false;
        
        return bal(left.left,right.right) && bal(left.right,right.left);
    }
}
