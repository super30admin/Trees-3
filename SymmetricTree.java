import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * BFS approach
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * Approach:
     * 1. Use a queue to maintain child nodes
     * 2. Add the child nodes of the two polled nodes in a specific order:
     *  - left.left and right.right
     *  - left.right and right.left
     * This ensures a mirrored traversal of the tree.
     * 3.
     */
    private boolean isSymmetricbfs(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null)
                continue;
            if (left == null || right == null) {
                return false;
            }

            if(left.val != right.val) {
                return false;
            }

            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n_4 = new TreeNode(4);
        TreeNode n_3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, n3, n4);
        TreeNode n_2 = new TreeNode(2, n_4, n_3);
        TreeNode n1 = new TreeNode(1, n2, n_2);

        SymmetricTree obj = new SymmetricTree();
        boolean symmetric = obj.isSymmetric(n1);
        System.out.println("result for dfs: " + symmetric);
        assert (symmetric);

        symmetric = obj.isSymmetricbfs(n1);
        System.out.println("result for bfs: " + symmetric);
        assert (symmetric);
    }
}
