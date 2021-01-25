// Time Complexity : O(n) where n is number of nodes in tree.
// Space Complexity : O(h) where h is height of the tree.
// Did this code successfully run on Leetcode : yes.
// Any problem you faced while coding this : no

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null && left.val != right.val) return false;
        return helper(left.left, right.left) && helper(left.right, right.left);
    }
}
// Your code here along with comments explaining your approach
