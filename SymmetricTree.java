// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// We use a dfs method that takes two TreeNode parameters, left and right, representing the corresponding nodes on the left and right subtrees. It checks three conditions: if both left and right nodes are null (empty subtrees), if either left or right node is null (indicating asymmetry), or if the values of left and right nodes are not equal (also indicating asymmetry). If any of these conditions are met, the method returns false.

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;

        if (left == null || right == null || left.val != right.val)
            return false;

        return dfs(left.left, right.right) && dfs(left.right, right.left);

    }

    public static void main(String[] args) {
        // Create the tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        SymmetricTree obj = new SymmetricTree();

        System.out.println("Is symmetric: " + obj.isSymmetric(root));
    }

}
