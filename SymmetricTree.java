/**
 * SymmetricTree checks if a binary tree is symmetric around its center using recursion.
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

public class SymmetricTree {
    boolean flag = true;

    public boolean isSymmetric(TreeNode root) {
        helper(root.left, root.right);
        return flag;
    }

    private void helper(TreeNode left, TreeNode right) {

        if (left == null && right == null) return;

        if (left == null  || right == null) {
            flag = false;
            return;
        }
        if (left.val != right.val) {
            flag = false;
            return;
        }

        helper(left.right, right.left);
        helper(left.left, right.right);
    }
}
