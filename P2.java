/*
 Recursive solution DFS

Time Complexity:
O(N) where N is the number of nodes, since each node is visited once.
Space Complexity:
O(H) where H is the height of the tree, for the recursive stack space (in the worst case, it could be O(N) for a skewed tree).

The solution checks if the tree is symmetric by comparing the left and right subtrees of the root using recursion.
The isMirror function compares two nodes to see if they are mirrors by checking their values and recursively comparing their children in reverse order.
If all corresponding pairs of nodes are symmetric, the tree is symmetric; otherwise, it is not.
 */

 class Solution {
    // Main function to check if the tree is symmetric
    public boolean isSymmetric(TreeNode root) {
        // If the tree is empty, it's symmetric; otherwise, check if left and right subtrees are mirrors of each other
        return root == null || isMirror(root.left, root.right);
    }

    // Helper function to check if two trees are mirrors of each other
    private boolean isMirror(TreeNode left, TreeNode right) {
        // If both nodes are null, they are mirrors (both empty)
        if (left == null && right == null) return true;
        
        // If one node is null and the other is not, they are not mirrors
        if (left == null || right == null) return false;
        
        // Check if current nodes' values are the same and recursively check if subtrees are mirrors
        return (left.val == right.val) &&
               isMirror(left.left, right.right) &&  // Check outer subtrees (left-left vs right-right)
               isMirror(left.right, right.left);    // Check inner subtrees (left-right vs right-left)
    }
}