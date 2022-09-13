/*
Time Complexity: O(N)
Space Complexity: O(N)
*/
class Solution{
public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        
       return validateTrees(root.left, root.right);
    }
    
    private boolean validateTrees(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if((left == null && right != null) || (left != null && right == null)) return false;
        if(left.val != right.val) return false;

        return validateTrees(left.left, right.right) && validateTrees(left.right, right.left);
    }
}