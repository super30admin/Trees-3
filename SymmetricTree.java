// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We recursively check if right and left nodes match 
// We return false if either node is null or their values are not equal

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }
    public boolean helper(TreeNode left, TreeNode right){
        if(right==null&&left==null)
            return true;
        if(left==null || right==null)
            return false;
        if(left.val!=right.val)
            return false;
        return helper(left.right, right.left) && helper(right.right, left.left);
    }