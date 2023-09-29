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
    List<List<Integer>> result;

    // Main function to find paths that sum up to the targetSum
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return new ArrayList<>();
        
        result = new ArrayList<>();
        inOrder(root, 0, targetSum, new ArrayList<>());
        return result;
    }

    // Helper function for inorder traversal
    private void inOrder(TreeNode node, int currSum, int targetSum, List<Integer> path) {
        if(node == null)
            return;

        // Add the current node's value to the path
        path.add(node.val);

        // Traverse left subtree, update current sum and path accordingly
        inOrder(node.left, currSum + node.val, targetSum, new ArrayList<>(path));
        
        // Check if it's a leaf node and if the sum matches the targetSum, add the path to the result
        if(node.right == null && node.left == null) {
            if(currSum + node.val == targetSum)
                result.add(new ArrayList<>(path));
        }
        
        // Traverse right subtree, update current sum and path accordingly
        inOrder(node.right, currSum + node.val, targetSum, new ArrayList<>(path));
    }
}

// Time Complexity: O(N^2) - In the worst case, where the tree is unbalanced and degenerates to a linked list, we might visit each node twice (once for inOrder and once for creating a new path). 
// Space Complexity: O(N^2) - In the worst case, where we might have N paths each of length N in the result list, the space complexity would be O(N^2).
