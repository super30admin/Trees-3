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
//Time Complexity: O(n).
//Space Complexity: O(1).

class Solution {
    boolean isSym;
    public boolean isSymmetric(TreeNode root) {
        isSym = true; 
        helper(root.left, root.right);
        return isSym;
        
    }
    
    private void helper(TreeNode left, TreeNode right){
        if(left == null && right == null) return;
        
        if(left == null || right == null || left.val != right.val){
            isSym = false;
            return;
        }

        helper(left.left, right.right);
        helper(left.right, right.left);
    }
}