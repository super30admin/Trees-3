
class TreeNode {
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

// TC: O(n) as all the traversed.
// SC: O(h) as recursion is used to traverse the elements. Hence Recursion stack
// counts as O(h). where h is height of inserted nodes.
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(2));
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));

        TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(2));
        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root1));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isItSymmetrix(root, root);
    }

    private static boolean isItSymmetrix(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return (root1.val == root2.val) && isItSymmetrix(root1.left, root2.right)
                && isItSymmetrix(root1.right, root2.left);
    }
}
