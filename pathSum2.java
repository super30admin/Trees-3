
    // Time Complexity (TC): O(n)
    // Each node is visited once, where n is the number of nodes in the tree.

    // Space Complexity (SC): O(h)
    // The maximum space used by the recursion stack and the current path list
    // is proportional to the height of the tree, where h is the height of the tree.

class Solution {
    // List to store the final result
    ArrayList<List<Integer>> result;
    // Variable to store the target sum
    int targetSum;

    // Main method to find all root-to-leaf paths where each path's sum equals the given sum
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // Initialize the result list
        this.result = new ArrayList<>();
        // Set the target sum
        this.targetSum = targetSum;
        // Call the helper method to start the recursion
        helper(root, 0, new ArrayList<Integer>());
        return result;
    }

    // Helper method for the recursion
    private void helper(TreeNode root, int currentSum, ArrayList<Integer> currentPath) {
        // Base case: if the current node is null, return
        if (root == null) return;

        // Add the current node's value to the current sum
        currentSum += root.val;
        // Add the current node's value to the current path
        currentPath.add(root.val);

        // Check if it's a leaf node and if the current sum equals the target sum
        if ((root.left == null && root.right == null) && currentSum == targetSum) {
            // If so, add a copy of the current path to the result list
            result.add(new ArrayList<>(currentPath));
        }

        // Recursively call the helper method for the left and right subtrees
        helper(root.left, currentSum, currentPath);
        helper(root.right, currentSum, currentPath);

        // Backtrack: remove the current node's value from the current path
        currentPath.remove(currentPath.size() - 1);
    }

}
