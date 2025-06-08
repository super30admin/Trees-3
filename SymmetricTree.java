//Solved Successfully on leetcode and faced no issues
//TC : O(n) Sc;O(h)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){return true;}
        return checking(root.left , root.right);
    }
    private boolean checking(TreeNode n1 , TreeNode n2){
        if(n1 == null && n2 == null){
            return true;
        }
        if(n1 == null || n2 == null || n1.val != n2.val){
            return false;
        }
        boolean left = checking(n1.left , n2.right);
        boolean right = checking(n1.right , n2.left);
        return left&&right;

    }
}