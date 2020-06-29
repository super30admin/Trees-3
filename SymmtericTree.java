// Time Complexity : O(n) where n is the number of tree nodes
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class SymmtericTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        return symmetricTree(root.left, root.right);
    }

    public boolean symmetricTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;

        return symmetricTree(left.left, right.right) &&
                symmetricTree(left.right, right.left);
    }
    public static void main(String[] args) {
        SymmtericTree tree= new SymmtericTree();
        //         1
        //       /   \
        //      2     2
        //     / \   / \
        //    3  4  4   3
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );

        boolean result = tree.isSymmetric(root);
        System.out.println("Is tree symmetric: " + result);
    }
}
