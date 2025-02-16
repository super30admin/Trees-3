

class SymmetryTree {
    boolean flag = true;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {

        TreeNode root1 = root.left; //left subtree
        TreeNode root2 = root.right; //right subtree

        helper(root1, root2);

        return flag;
    }

    private void helper(TreeNode root1, TreeNode root2){

        if(root1 == null && root2 == null) return;

        if(root1 == null || root2 == null){
            flag = false;
            return;
        }

        if(root1.val != root2.val){
            flag = false;
        }

        helper(root1.left, root2.right);
        helper(root1.right, root2.left);
    }
}