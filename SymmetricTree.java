// Time Complexity : O(N), all the nodes in the tree
// Space Complexity : O(h), height of the tree, h nodes in the recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// We will need to compare the left child and right child of the node to check for symmetry. If any one of them is null,
// the tree is not symmetric, return false. Then the left subtree should be compared to the right subtree and vice versa.
// If their values don't match return false;
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isTreeSymmetric(root.left, root.right);
    }

    private boolean isTreeSymmetric(TreeNode leftChild, TreeNode rightChild) {
        if(leftChild == null && rightChild == null) return true;
        if(leftChild == null || rightChild == null) return false;

        if(leftChild.val == rightChild.val){
            return isTreeSymmetric(leftChild.left, rightChild.right) && isTreeSymmetric(leftChild.right, rightChild.left);
        }

        return false;
    }
}
