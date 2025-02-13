// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
check validity conditions at each node
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.right, root.left);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        if (t1.val != t2.val)
            return false;

        return (isMirror(t1.right, t2.left) &&
                isMirror(t1.left, t2.right));
    }
}