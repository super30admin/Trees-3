//TC:O(n)
//SC:O(h)

class symmetricTree {
    boolean isSymmetric; // A flag to track whether the tree is symmetric

    // Main method to check if the binary tree is symmetric
    public boolean isSymmetric(TreeNode root) {
        // If the tree is empty, it is symmetric
        if (root == null) {
            return true;
        }

        // Initialize the isSymmetric flag to true
        isSymmetric = true;

        // Perform a recursive depth-first search to compare the left and right subtrees
        dfs(root.left, root.right);

        // Return the result of the symmetry check
        return isSymmetric;
    }

    // Helper method for recursive DFS to check symmetry
    public void dfs(TreeNode left, TreeNode right) {
        // Base case: If both nodes are null, this subtree is symmetric
        if (left == null && right == null) {
            return;
        }

        // Base case: If one node is null and the other is not, the tree is not symmetric
        if (left == null || right == null) {
            isSymmetric = false; // Mark the tree as not symmetric
            return; // Exit recursion for this branch
        }

        // Base case: If the values of the two nodes are not equal, the tree is not symmetric
        if (left.val != right.val) {
            isSymmetric = false; // Mark the tree as not symmetric
            return; // Exit recursion for this branch
        }

        // Recursive calls to check the symmetry of:
        // 1. The outer subtrees (left.left and right.right)
        // 2. The inner subtrees (left.right and right.left)
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}