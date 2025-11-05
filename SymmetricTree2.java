/**
 * SymmetricTree2 checks if a binary tree is symmetric around its center using recursion.
 *
 * Approach:
 * - Uses a recursive helper function to compare the left and right subtrees.
 * - Checks if the left subtree is a mirror reflection of the right subtree.
 * - At each recursive call, compares the values of the current nodes and recurses into opposite children.
 *
 * Time Complexity:
 * - O(N), where N is the number of nodes in the tree. Each node is visited once.
 *
 * Space Complexity:
 * - O(H), where H is the height of the tree, due to the recursion stack. In the worst case (completely unbalanced tree), H = N.
 */

public class SymmetricTree2 {

    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {

        if (left == null && right == null) return true;

        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        return helper(left.right, right.left) && helper(left.left, right.right);
    }
}
