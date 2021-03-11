// The idea is to recursively check whether the mirror image of tree is equal. ie., the root.left and root.right, and root.right and root.left elements are the same. 

// Time Complexity : O(n), where n is the number of nodes in the given tree
// Space Complexity : O(h), where h is the height of the given tree

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;

        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public static void main(String[] args) {
        SymmetricTree sTree = new SymmetricTree();
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        System.out.println(sTree.isSymmetric(root));
    }
}
