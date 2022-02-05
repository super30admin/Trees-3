//Time Complexity: O(n)
//Space Complexity: O(h) height of the tree
//In this problem, we recurse on the parents's left and right nodes to check if they are equal. And also we recurse on the left
//node's right child and right node's left child in order to make sure that we have a symmetric tree
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null ) return true;
        return helper(root.left, root.right);
    }
    public boolean helper (TreeNode left, TreeNode right){
        //base
        if(left == null && right == null) return true;
        if(left != null && right == null) return false;
        if(left == null && right != null) return false;
        if(left.val != right.val) return false;
        //logic
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
    
}