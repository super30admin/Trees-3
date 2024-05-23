//time O(N)
//space O(h)

class Solution {
    boolean flag = true;
    public boolean isSymmetric(TreeNode root) {
        helper(root.left, root.right);
        return flag;
    }
    
    private void helper(TreeNode left, TreeNode right) {
        //base
        if(left == null && right == null) return; 
        
        //logic
        if(left == null || right == null || left.val != right.val) {
            flag = false;
            return;
        }
        helper(left.left, right.right);
        helper(left.right, right.left);
    }
}
