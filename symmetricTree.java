/* Running time Complexity: O(n)
Space Complexity: O(n)
Successfully Run and Compiled on leetcode
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
    boolean valid;
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        valid = true;
        helper(root.left,root.right);
        return valid;
    }
    private void helper(TreeNode left, TreeNode right){
        //base
        if(left == null && right == null) return;
        if(left==null || right==null || left.val!=right.val){
            valid = false;
            return;
        }
        // System.out.print("value of left "+left.val);
        // System.out.println(" and value of right "+right.val);
        //logic
        helper(left.left,right.right);
        // System.out.println("going down");
        helper(left.right,right.left);
    }
}