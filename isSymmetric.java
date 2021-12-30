// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No



class Solution {
    boolean isValid;
    public boolean isSymmetric(TreeNode root) {
        isValid = true;
        if(root == null)
            return isValid;
        dfs(root.left,root.right);
        return isValid;
    }
    public void dfs(TreeNode left,TreeNode right){
        if(left == null && right == null)
            return;
        if(left == null || right == null || left.val != right.val){
            isValid = false;
            return;
        }
        if(isValid)
            dfs(left.left,right.right);
        if(isValid)
            dfs(left.right,right.left);
    }
}
