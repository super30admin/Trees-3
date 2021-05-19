// Time Complexity : O(n)
// Space Complexity : O(h) ; worst case- O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No





class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return symmetric(root.left,root.right);
        
    }
    public boolean symmetric(TreeNode left, TreeNode right){
        //base case
        if(left == null && right==null){
            return true;
        }
        
        
        if(left!=null && right!=null){
          return left.val == right.val && symmetric(left.left, right.right)  && symmetric(right.left,left.right);
        }
        return false;
    }
}