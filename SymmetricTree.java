// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root.left,root.right);
    }
    boolean helper(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null || left.val!=right.val){
            return false;
        }
        return helper(left.left,right.right) && helper(left.right,right.left);
    }
}