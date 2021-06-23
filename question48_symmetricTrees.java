package Trees3;

public class question48_symmetricTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val)
        {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
        Time Complexity: O(N)
        Space Complexity: O(N)
    */
    public boolean isSymmetric(TreeNode root) {
        return symmetry(root, root);
    }
    private boolean symmetry(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val == root2.val)
            return symmetry(root1.left, root2.right) && symmetry(root1.right, root2.left);
        return false;
    }
}