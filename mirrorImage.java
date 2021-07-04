// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public boolean isSymmetric(TreeNode root) {
         return helper(root.right, root.left);
    }
    private boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        else if(left == null || right == null || left.val != right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}