/**
 * TC - O(n)
 * Sc - O(h) for recursive stack
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;

        return helper(root.left, root.right);
    }
    public boolean helper(TreeNode left, TreeNode right)
    {
        //base
        if(left==null&&right==null) return true;

        //logic
        if(left==null||right==null||left.val!=right.val)
        {
            return false;
        }

        return helper(left.left,right.right) && helper(left.right,right.left);
    }
}