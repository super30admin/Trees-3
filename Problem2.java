//Brute Force
//Time = O(n)
//Space = O(n)

class Solution {
    public boolean isSymmetric(TreeNode root) {
        // If root is null, return true (an empty tree is symmetric)
        if (root == null) {
            return true;
        }
        // Call isMirror on the left and right subtrees of the root,
        // and return whether they are mirrors of each other
        return isMirror(root.left, root.right);
    }
    
    public boolean isMirror(TreeNode node1, TreeNode node2) {
        // If both nodes are null, they are mirrors of each other
        if (node1 == null && node2 == null) {
            return true;
        }
        // If one node is null and the other is not, they are not mirrors
        if (node1 == null || node2 == null) {
            return false;
        }
        // If both nodes have different values, they are not mirrors
        if (node1.val != node2.val) {
            return false;
        }
        // Check if the left subtree of node1 is a mirror of the right subtree of node2,
        // and if the right subtree of node1 is a mirror of the left subtree of node2
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }
}
