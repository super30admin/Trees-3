
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {

        return helper(root, root);
    }

    private boolean helper(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;

        return (node1.val == node2.val) && helper(node1.left, node2.right) && helper(node1.right, node2.left);
    }
}
// TC: O(n) SC:O(1)