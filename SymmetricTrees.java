public class SymmetricTrees {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return helper(root.left,root.right);
    }
    private boolean helper(TreeNode leftNode, TreeNode rightNode){
        if(leftNode == null && rightNode == null)
            return true;
        if(leftNode == null || rightNode == null)
            return false;

        return 
        leftNode.val == rightNode.val  && 
        helper(leftNode.left,rightNode.right) &&
        helper(leftNode.right,rightNode.left);
    }
}
