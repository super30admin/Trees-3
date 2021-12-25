// Time Complexity : O(n)
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return dfs(root.left,root.right);
    }
    private boolean dfs(TreeNode left, TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null||left.val!=right.val){
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}