//Time Complexity: O(n) where n is the number of nodes in the binary tree
//Space Complexity: O(n) for the recursive stack space in the worst case

/**
 * Determines whether a binary tree is symmetric around its center.
 * Uses a helper function to recursively compare left and right subtrees in a mirrored manner.
 * @param root the root node of the binary tree
 */

public class SymmetricTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
    }
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }

        return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
}

