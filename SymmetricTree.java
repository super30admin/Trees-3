public class SymmetricTree {
    public class TreeNode {
        int val;
        SymmetricTree.TreeNode left;
        SymmetricTree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, PreorderInorder.TreeNode left, PreorderInorder.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        /*
        TC: O(n)
        SC: O(h)-> O(n) stack space
        */
        if(root==null) return false;

        return helper(root.left,root.right);
    }

    private boolean helper(TreeNode left,TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null || left.val!=right.val){
            return false;
        }

        return helper(left.left,right.right) && helper(left.right,right.left);
    }
}
