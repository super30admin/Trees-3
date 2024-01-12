public class SymmetricTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    // TC: O(N) where N is number of nodes in tree
    // SC: O(H) where H is max height of tree
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    private boolean helper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null) {
            return false;
        } else if (root1 != null && root2 == null) {
            return false;
        } else if (root1 == null && root2 == null) {
            return true;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return helper(root1.left, root2.right) && helper(root1.right, root2.left);
    }
}
