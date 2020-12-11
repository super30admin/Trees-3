/** Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
* TC O(N) and SC O(N)
* Code submitted on leetcode
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode left, TreeNode right) {
         if (left == null && right == null) 
            return true;
        if (left == null && right != null) return false;
        if (right == null && left != null) return false;
        if (right.val != left.val) return false;
       
        return helper(left.left, right.right) && helper(left.right, right.left);
            
    }
}
