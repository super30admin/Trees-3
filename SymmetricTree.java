/**
 * Leetcode 101. Symmetric Tree
 * Link: https://leetcode.com/problems/symmetric-tree/description/
 */
// ---------------------------------- Solution 1 -------------------------------------
public class SymmetricTree {
    /**
     * Void based conditional recursive solution with global variable using preorder level computing. As we are trying to
     * find symmetric tree, left subtree left child is compared with right subtree right child
     * and left subtree right child is compared with right subtree left child
     *
     * TC: O(n) Auxiliary SC: O(1)
     * Recursive stack SC: O(h) h -> height of tree, worst case O(n), complete BST O(log n)
     */
    boolean result;
    public boolean isSymmetric(TreeNode root) {
        this.result = true;
        dfs(root.left, root.right);
        return result;
    }

    private void dfs(TreeNode left, TreeNode right) {
        //base
        if ((left == null && right == null) || !result) {
            return;
        }

        //logic
        if (left == null || right == null || left.val != right.val) { //if either left or right is null or value doesnt match ->false
            result = false;
        }

        if (result) { //continue recursion only if tree is so far symmetric
            dfs(left.right, right.left);
            dfs(left.left, right.right);
        }
    }
}

// ---------------------------------- Solution 2 -------------------------------------
class SymmetricTree2 {
    /**
     * boolean based recursive function with no global variable using the same logic as above
     *
     * TC: O(n) Auxiliary SC: O(1)
     * Recursive stack SC: O(h) h -> height of tree, worst case O(n), complete BST O(log n)
     */
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        //base
        if (left == null && right == null) {
            return true;
        }

        //logic
        if (left == null || right == null || left.val != right.val) { //if either left or right is null or value doesnt match ->false
            return false;
        }

        return dfs(left.right, right.left) && dfs(left.left, right.right);
    }
}
