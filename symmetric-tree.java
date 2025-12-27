// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

class Solution {
    boolean flag;

    public boolean isSymmetric(TreeNode root) {
        this.flag = true;
        if (root == null)
            return true;
        helper(root.left, root.right);
        return flag;
    }

    private void helper(TreeNode left, TreeNode right) {
        //base 
        if (left == null && right == null)
            return;

        //logic
        if (left == null || right == null || left.val != right.val) {
            flag = false;
            return;
        }
        helper(left.left, right.right);
        helper(left.right, right.left);

    }
}