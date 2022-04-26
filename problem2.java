import javax.swing.tree.TreeNode;

class symmetricTree{
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right){

        if(left == null && right == null) return true;

        if(left == null || right == null || left.val != right.val){
            return false;
        }

        boolean case1 = dfs(left.left, right.right);
        boolean case2 = dfs(left.right, right.left);
        return case1 && case2;
    }
}