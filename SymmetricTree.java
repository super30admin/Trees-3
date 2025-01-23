/*
 * TC: O (n)
 * SC: O (h) where h is height of tree
 *
 * Approach: for each pair of nodes starting at the root,
 * check if the values are equal and t1's left mirrors t2's right
 * and t2's left mirrors t1's right
 */
public class SymmetricTree {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        // base cases
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        // check if the values are equal and t1's left mirrors t2's right
        // and t2's left mirrors t1's right
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}
