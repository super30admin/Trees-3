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
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        this.flag = true;
        if(root == null) return true;
        helper(root.left, root.right);
        return flag;
    }

    private void helper(TreeNode left, TreeNode right){
        //base
        if(left == null && right == null) return;
        //logic
        if(left == null || right == null || left.val != right.val){ //If the values are not equal return false
            flag = false;
            return;
        }
        System.out.println(left.val);
        System.out.println(right.val);

        helper(left.left, right.right); //Check the values at the left of left and right of right
        helper(left.right, right.left); //Check the values at the right of left and left of right
    }
}
