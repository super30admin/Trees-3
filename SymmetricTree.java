/**
 * Time Complexity: O(n)
 * Space complexity: O(h); height of the tree
 * Ran on leetcode? Yes
 * Problems faced? No
 *
 * Approach:
 * 1. Use a helper function (dfs) to compare the left and right subtrees for symmetry.
 * 2. Both left and right nodes are null: Continue as they are symmetric.
 * One node is null while the other is not: Mark the tree as not symmetric.
 * The values of the two nodes differ: Mark the tree as not symmetric.
 * 3. Compare the left child of the left subtree with the right child of the right subtree.
 * Compare the right child of the left subtree with the left child of the right subtree.
 * 4. If asymmetry is detected at any point, stop further checks by setting isSymmetric to false
 */
public class SymmetricTree {
    public static class TreeNode {
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
    boolean isSymmetric = true;
    public boolean isSymmetric(TreeNode root) {
        dfs(root.left, root.right);
        return isSymmetric;
    }

    private void dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return;
        }

        if (left == null || right == null) {
            isSymmetric = false;
            return;
        }

        if (left.val != right.val) {
            isSymmetric = false;
            return;
        }

        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}
