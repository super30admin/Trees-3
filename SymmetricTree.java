//Time Complexity: O(h)
//Space Complexity: O(1)
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    public boolean helper(TreeNode root, TreeNode root1){
        if(root==null && root1==null){
            return true;
        }
        if(root==null || root1==null){
            return false;
        }
        return ((root.val==root1.val) && helper(root.left, root1.right) && helper(root.right, root1.left));
    }
}
