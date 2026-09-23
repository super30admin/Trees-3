/*
Approach:

Compare the left and right subtrees as mirror images.
Their values must match, while the left's left subtree is compared with the right's right subtree and vice versa.
Recursively continue until both nodes are null or a mismatch is found.

Time: O(n)
Space: O(h) — recursion stack.
*/
class SymmetricTreeRec {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {

        // Both nodes are null
        if (left == null && right == null) {
            return true;
        }

        // One node is null
        if (left == null || right == null) {
            return false;
        }

        // Values must be equal and subtrees must be mirrors
        return left.val == right.val
                && isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }
}

