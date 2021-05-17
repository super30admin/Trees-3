/*
Desc : both the left and right sub trees undergo inorder traversal and at every corresponding element
if the elements are not equal false is returned.
Time Complexity : O(n)
Space Complexity :  O(1)
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        
        return helper(root.left,root.right);
    }
    private boolean helper(TreeNode left,TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val != right.val){
            return false;
        }
        return helper(left.left,right.right) && helper(left.right,right.left);
    }
}
