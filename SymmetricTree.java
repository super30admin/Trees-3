// Time Complexity : O(n), where n is the number of nodes (each node compared at most once).
// Space Complexity : O(h) for recursion stack, where h is the tree height (O(log n) for balanced, O(n) worst-case).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// - A tree is symmetric if its left and right subtrees are mirror images.
// - Recursively compare pairs (left, right): values must match AND
//   left.left mirrors right.right AND left.right mirrors right.left.

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    // Returns true if two subtrees are mirror images
    private boolean helper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        return root1.val == root2.val
                && helper(root1.left, root2.right)
                && helper(root1.right, root2.left);
    }

    // --- Main method for testing ---
    public static void main(String[] args) {
        // Example 1: Symmetric
        TreeNode s1 = new TreeNode(1);
        s1.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        s1.right = new TreeNode(2, new TreeNode(4), new TreeNode(3));

        // Example 2: Not symmetric
        TreeNode s2 = new TreeNode(1);
        s2.left = new TreeNode(2, null, new TreeNode(3));
        s2.right = new TreeNode(2, null, new TreeNode(3));

        SymmetricTree sol = new SymmetricTree();
        System.out.println("Example 1 symmetric? " + sol.isSymmetric(s1)); // true
        System.out.println("Example 2 symmetric? " + sol.isSymmetric(s2)); // false
    }
}

