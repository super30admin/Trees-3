//101. Symmetric Tree

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    boolean isValid;
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        isValid = true;
        dfs(root.left, root.right);
        return isValid;
    }
    private void dfs(TreeNode left, TreeNode right){
        if(left == null && right == null) return;
        if(left == null || right == null || left.val != right.val){
            isValid = false;
            return;
        }
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}