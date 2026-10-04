//Time Complexity: O(n)
//Space Complexity: O(h)
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        //base
        if(left == null && right == null) return true;
        //logic

        if(left == null || right == null) return false;
        if(left != null && right != null) {
            if(left.val != right.val) {
                return false;
            }
        }

        return helper(left.left, right.right) && helper(left.right, right.left);

    }
}

