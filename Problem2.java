/*
Check if given tree is symmetric
time: O(n)
space: O(1)
 */
public class Problem2 {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if(left==null && right==null) return true;
        if(left==null || right==null) return false;



        boolean x = helper(left.right, right.left);
        boolean y = helper(left.left, right.right);

        return x&&y&&(left.val==right.val);

    }
}
