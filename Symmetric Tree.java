// Time Complexity : O(n) n is the number of nodes in a tree
// Space Complexity : O(h) h i sthe height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return dfs(root.left,root.right);
    }
    private boolean dfs(TreeNode left, TreeNode right){
        if(left==null&&right==null)
            return true;
        if(left==null||right==null||left.val!=right.val)
            return false;
        return dfs(left.right,right.left) && dfs(left.left,right.right) ;
    }
}

