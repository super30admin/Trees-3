// Time Complexity :O(n) where we have to go to each node in both halves
// Space Complexity :O(h) where h is height of tree.. the stack has recursive calls
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

// helper function takes in two params (r,l)
// we check fo three conditions
// when both params are null, return true as you have reached the end for both and its still true
// if above condition is false, check either of them is null.. return false(since if both were null it would be returned in the above case)
// we reach here if both have values.. return false if they have different value
// else if they have same value, continue revursively for helper(l.left,r.right) && helper(l.right,r.left)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // base case
        if (root == null)
            return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode l, TreeNode r) {
        if (l == null && r == null)
            return true;
        if (l == null || r == null)
            return false;

        if (l.val != r.val)
            return false;

        return helper(l.left, r.right) && helper(l.right, r.left);
    }
}