class SymmetricTree {
    boolean isSymmetric = true;
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        isSymmetric(root.left, root.right);
        return isSymmetric;
    }

    public void isSymmetric(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return;
        }
        if(left==null || right == null){
            isSymmetric = false;
            return;
        }
        if(left.val!=right.val){
            isSymmetric = false;
            return;
        }
        isSymmetric(left.left, right.right);
        isSymmetric(left.right, right.left);
    }
}
