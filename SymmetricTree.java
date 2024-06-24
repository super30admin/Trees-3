//Time - O(n), Space - O(h)
public class SymmetricTree {//time - O(n), space - O(h)
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSymmetric(root, root);
    }
    private boolean isSymmetric(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }

        boolean left = isSymmetric(root1.left, root2.right);
        boolean right = isSymmetric(root1.right, root2.left);

        return left && right;
    }
}
