// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        helper(root, targetSum, currentPath, result);
        return result;
    }

    private void helper(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        // Add the current node to the path
        currentPath.add(node.val);

        // If it's a leaf node and its value matches the remaining target sum, add the path to the result
        if (node.left == null && node.right == null && targetSum == node.val) {
            result.add(new ArrayList<>(currentPath));
        }

        // Recurse on the left and right subtrees with updated target sum and current path
        helper(node.left, targetSum - node.val, currentPath, result);
        helper(node.right, targetSum - node.val, currentPath, result);

        // Remove the current node from the path to backtrack
        currentPath.remove(currentPath.size() - 1);
    }
}