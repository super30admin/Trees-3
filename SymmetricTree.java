/**
 * Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * * Approach: Recursive Comparison
 * 1. If the tree is empty, it is symmetric.
 * 2. Compare the left and right subtrees recursively.
 * 3. For each pair of nodes, check:
 *   - If both nodes are null, they are symmetric.  
 *   - If one node is null and the other is not, they are not symmetric.
 *   - If both nodes are not null, check if their values are equal and recursively check:
 *      - The left child of the left node with the right child of the right node.
 *      - The right child of the left node with the left child of the right node.
 * * Time Complexity: O(N), where N is the number of nodes in the tree, as each node is visited once.
 * * Space Complexity: O(H), where H is the height of the tree, due to the recursion stack.
 * 
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
