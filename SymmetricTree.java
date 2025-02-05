// Approach: A single node is always symmetric. So, we need to check whether the left and right subtrees of the root are mirror images of
// each other. Perform a preorder traversal of both subtrees, comparing their data values and recursively checking if the left subtree of
// one is symmetric with the right subtree of the other. Handle base cases where both roots are null or when only one of them is null.
// Time Complexity: O(n) where n - node count
// Space Complexity: O(h) for recursion stack where h - height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// https://leetcode.com/problems/symmetric-tree/description/

public class SymmetricTree {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode (int v) {
            val = v;
        }
    }

    boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return areMirrorImages(root.left, root.right);
    }

    boolean areMirrorImages(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return areMirrorImages(root1.left, root2.right) && areMirrorImages(root1.right, root2.left);
    }

    public static void main(String[] args) {
        SymmetricTree st = new SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println("Given binary tree is a mirror image of itself i.e. symmetric around its center (true/false): " + st.isSymmetric(root));
    }
}