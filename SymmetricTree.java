
public class SymmetricTree {
        public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode a, TreeNode b){
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        return a.val == b.val && helper(a.left, b.right) && helper(a.right, b.left);
    }
}
