/**
 * TreeNode represents a node in a binary tree.
 *
 * Fields:
 * - int val: The value of the node.
 * - TreeNode left: Reference to the left child.
 * - TreeNode right: Reference to the right child.
 *
 * Usage:
 * - Used as the fundamental building block for binary tree problems.
 *
 * Time Complexity: N/A (data structure)
 * Space Complexity: N/A (data structure)
 */
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
