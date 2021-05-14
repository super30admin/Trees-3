// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    In order to check for symmetricity of the tree, we traverse the right subtree in left, right manner.
    We also traverse the left subtree in right, left manner.
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return traverse(root.left, root.right);
    }
    
    public boolean traverse(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null && rightRoot == null) return true;
        else if (leftRoot == null || rightRoot == null) return false;
        if (leftRoot.val != rightRoot.val) return false;
        return traverse(leftRoot.left, rightRoot.right) && traverse(leftRoot.right, rightRoot.left);
    }
}