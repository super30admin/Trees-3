// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        this.flag=true;
        dfs(root.left, root.right);
        return this.flag;
    }
    public void dfs(TreeNode left, TreeNode right){
        if(left==null&&right==null) return;
        if(left==null || right==null || left.val!=right.val){
            flag=false;
            return;
        }
        if(flag) dfs(left.left, right.right);
        if(flag) dfs(left.right, right.left);
    }
}