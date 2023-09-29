/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Function to check if a binary tree is symmetric
    public boolean isSymmetric(TreeNode root) {
        if(root==null) // If the root is null, it is symmetric
            return true;
        
        Queue<TreeNode> q=new LinkedList<>(); // Queue to store nodes for BFS traversal
        q.add(root.left);
        q.add(root.right);

        while(!q.isEmpty()) {
            TreeNode left = q.poll(); // Get the left node
            TreeNode right = q.poll(); // Get the right node

            // If both nodes are null, they are symmetric
            if (left == null && right == null)
                continue;

            // If only one of the nodes is null, they are not symmetric
            if (left == null || right == null)
                return false;

            // If the values of the nodes are not equal, they are not symmetric
            if (left.val != right.val)
                return false;

            // Add left subtree's left and right subtree's right for comparison
            q.add(left.left);
            q.add(right.right);

            // Add left subtree's right and right subtree's left for comparison
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
}

// Time Complexity: O(N) - where N is the number of nodes in the binary tree
// Space Complexity: O(h) - where h is the height of the binary tree
