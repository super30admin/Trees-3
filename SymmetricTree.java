// Recursive Method : Using DFS

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null || right == null || left.val != right.val)
            return false;
        
        boolean case1 = helper(left.left, right.right);
        boolean case2 = helper(left.right, right.left);
        
        return case1 && case2;
    }
}
