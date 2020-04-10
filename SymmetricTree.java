// Time COmplexity: O(n)
// Space with recursive stack: O(max depth)
// Space without recursive stack: O(1)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }

        if(left == null || right == null) {
            return false;
        }

        if(left.val != right.val) {
            return false;
        }

        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}