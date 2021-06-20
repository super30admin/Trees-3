// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
// The basic idea is to traverse each node in the tree and check if the tree is symmetric using recursion
class Solution {
    public boolean isSymmetric(TreeNode root) {
       if(root== null || ( root.left == null && root.right == null)) return true;
          
       return checkSymmetry(root.left,root.right);   
    }
          

    public boolean checkSymmetry(TreeNode left, TreeNode right) {
        if(left == null && right== null)
            return true;
        else if(left == null || right == null || left.val != right.val)
            return false;
        else
            return checkSymmetry(left.left,right.right) && checkSymmetry(left.right,right.left);
    }
}