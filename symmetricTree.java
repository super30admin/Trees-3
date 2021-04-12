// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here  with comments explaining your approach

class Solution {
    boolean isValid;

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        isValid = true;
        helper(root.left, root.right);
        return isValid;
    }

    private void helper(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return;
        // if values dont match then return false
        if (node1 == null || node2 == null || node1.val != node2.val) {
            isValid = false;
            return;
        }
        // navigate both left and right subtrees
        helper(node1.left, node2.right);
        helper(node1.right, node2.left);
    }
}