class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return helper(root.left, root.right);
    }
    public boolean helper(TreeNode left, TreeNode right){
        if(left==null && right==null)
            return true;
        if(left!=null && right!=null && left.val!=right.val){
            return false;
        }
        if(left==null || right==null)
            return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}

//Time complexity : O(N) N is the number of elements in the tree
//Space complexity : O(H) H is the height of recursive stack
