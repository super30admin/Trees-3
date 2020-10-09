// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes

class Solution {
    public boolean isSymmetric(TreeNode root) {
         return helper(root, root);
    }
    
    public boolean helper(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    return (t1.val == t2.val)
        && helper(t1.right, t2.left)
        && helper(t1.left, t2.right);
    }
}