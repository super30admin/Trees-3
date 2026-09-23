/*Approach:
1. Use DFS while maintaining the current path and subtract each node's value from targetSum.
2. When a leaf is reached with targetSum == node.val, add a copy of the current path to the result.
3. Backtrack by removing the current node before returning to explore another path.

Time Complexity: O(n × h) worst case, due to copying valid paths.
Space Complexity: O(h) auxiliary space for recursion and the current path, excluding the output.*/

import java.util.*;

class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, path, result);

        return result;
    }

    private void dfs(TreeNode node, int targetSum,
                     List<Integer> path,
                     List<List<Integer>> result) {

        if (node == null) {
            return;
        }

        // Add current node to path
        path.add(node.val);

        // Check if current node is a leaf
        if (node.left == null && node.right == null
                && targetSum == node.val) {

            result.add(new ArrayList<>(path));
        }

        // Explore left and right subtrees
        dfs(node.left, targetSum - node.val, path, result);
        dfs(node.right, targetSum - node.val, path, result);

        // Backtrack
        path.remove(path.size() - 1);
    }
}

