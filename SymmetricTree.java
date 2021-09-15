// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isSymmetric(TreeNode root) {
        // return false if tree is empty
        if(root == null) return false;
        // call recursive function
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode left, TreeNode right){
        // return if leaf node is reached
        if(left == null && right == null) return true;
        // check for binary tree constraints
        else if((left == null && right != null) || (left != null && right == null)) return false;
        // if the value is not equal return false
        if(left.val != right.val){
            return false;
        }
        // call the recursive functions for mirror sub trees
        return (helper(left.left,right.right) && helper(left.right, right.left));
    }
}