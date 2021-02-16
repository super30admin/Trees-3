// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class Solution {
    public boolean isSymmetric(TreeNode root) {

        return root == null || isSymmetric(root.left, root.right);
    }

    boolean isSymmetric(TreeNode p, TreeNode q) {
        // both are leaf
        if (p == null && q == null)
            return true;

        // both not leaf
        if (p == null || q == null)
            return false;

        // their level is same and their right and left are symmetric
        return (p.val == q.val) && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }
}