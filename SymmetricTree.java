//TIme Complexity: O(N) n is the number of nodes
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return isCheck(root.left, root.right);
    }

    private boolean isCheck(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if((root1 == null && root2 != null) ||(root1 != null && root2 == null)){
            return false;
        }
        return (root1.val == root2.val) && isCheck(root1.left, root2.right) && isCheck(root1.right, root2.left);
    }
}
