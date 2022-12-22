//TC : o(n)
//SC : o(h) (recursive stack space)
//https://leetcode.com/problems/symmetric-tree/
class Solution {
    boolean flag = true;
    public boolean isSymmetric(TreeNode root) {
        dfs(root.left,root.right);
        return flag;
    }
    private void dfs(TreeNode left, TreeNode right){
        //base
        if(left == null && right == null) return;
        //logic
        if(left == null || right == null || left.val != right.val){
            flag = false;
            return;
        }
        
        if(flag)
            dfs(left.left, right.right);
        if(flag)
            dfs(left.right, right.left);
    }
}
