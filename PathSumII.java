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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, targetSum, currentPath, result);
        return result;
    }

    private void dfs(TreeNode node, int remainingSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) return;

        // Add current node to the path
        currentPath.add(node.val);
        remainingSum -= node.val; // Subtract node value from remaining sum

        // Check if it's a leaf node and sum matches targetSum
        if (node.left == null && node.right == null && remainingSum == 0) {
            result.add(new ArrayList<>(currentPath));
        } else {
            // Continue DFS for left and right subtrees
            dfs(node.left, remainingSum, currentPath, result);
            dfs(node.right, remainingSum, currentPath, result);
        }

        // Backtrack: remove the last node from path
        currentPath.remove(currentPath.size() - 1);
    }
}