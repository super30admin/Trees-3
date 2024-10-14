class Solution {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        flag =true;
        dfs(root.left,root.right);
        return flag;
    }
    private void dfs(TreeNode left, TreeNode right){
        if(left==null && right==null)
        return;

        if(left==null || right==null || left.val!=right.val){
            flag=false; return ;
        }

        dfs(right.left,left.right);
        dfs(left.left,right.right);

    }
}
