// Time Complexity : O(n*h)
// Space Complexity : O(n*h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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
    // Define a global variable to store the result
    private List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // Initialize the global result variable
        result = new ArrayList<>();
        // Start DFS traversal
        dfs(root, targetSum, new ArrayList<>());
        // Return the result
        return result;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> path) {
        if (node == null) {
            return;
        }

        // Add the current node to the path
        path.add(node.val);

        // Check if we are at a leaf node and if the path sum equals the targetSum
        if (node.left == null && node.right == null && node.val == targetSum) {
            result.add(new ArrayList<>(path));  // Add a copy of the current path to the result
        } else {
            // Continue to search in the left and right subtree
            dfs(node.left, targetSum - node.val, path);
            dfs(node.right, targetSum - node.val, path);
        }

        // Backtrack: Remove the current node from the path
        path.remove(path.size() - 1);
    }
}
