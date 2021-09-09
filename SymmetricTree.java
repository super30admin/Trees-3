//https://leetcode.com/problems/symmetric-tree/
/*
Time: O(n)
Space: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return false;

        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;

        if (left.val != right.val)
            return false;

        return helper(left.left, right.right) && helper(left.right, right.left);
    }

}

/* Method slight change:
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
            return true;
        if(t1 == null || t2 == null)
            return false;
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}
*/