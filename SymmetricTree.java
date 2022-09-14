public class SymmetricTree {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        //null check
        if(root==null) return true;
        flag = true;
        dfs(root.left,root.right);
        return flag;
    }
    private void dfs(TreeNode left,TreeNode right){
        //base case
        if(left==null && right==null) return;
        if(left==null||right==null||left.val!=right.val) {
            flag = false;
            return;
        }
        //logic
        if(flag) dfs(left.left,right.right);
        if(flag) dfs(left.right,right.left);
    }
}
