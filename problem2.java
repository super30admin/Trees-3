//Time Complexity: O(n) — each node is visited once.
//Space Complexity: O(h) — due to recursion stack, where h is the height of the tree.

//Use a recursive helper to compare the left and right subtrees.
//At each step, ensure current nodes are equal and their subtrees are mirrors.
//Recursively check outer and inner pairs: left.left vs right.right and left.right vs right.left.

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null) return false;
        if (leftNode.val != rightNode.val) return false;

        return isMirror(leftNode.left, rightNode.right) && isMirror(leftNode.right, rightNode.left);
    }
}
