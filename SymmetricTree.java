//Time Complexity: O(n)
//Space Complexity: O(h) height of the tree

class SymmetricTree {
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