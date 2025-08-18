import java.util.*;
// Time Complexity : O(n) to traverse all nodes, plus the cost of copying paths when matches occur.
//                   In the worst case (skewed tree with many matching root-to-leaf paths), copying can add up to O(n^2).
// Space Complexity : O(h) auxiliary for recursion and current path (h = tree height), plus output storage for all matching paths.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// - Use DFS with backtracking.
// - Maintain a running sum and a list `path` representing the current root-to-node path.
// - When a leaf is reached, if running sum equals target, add a COPY of `path` to `result`.
// - After exploring a node’s children, remove the node from `path` (backtrack).
public class PathSum {

    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    // DFS helper with backtracking
    private void helper(TreeNode root, int targetSum, int sum, List<Integer> path) {
        if (root == null) return;

        // Choose
        sum += root.val;
        path.add(root.val);

        // Check leaf
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path)); // add a copy
            }
        }

        // Explore
        helper(root.left, targetSum, sum, path);
        helper(root.right, targetSum, sum, path);

        // Un-choose (backtrack)
        path.remove(path.size() - 1);
    }

    // --- Main method for testing ---
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int target = 22;

        PathSum sol = new PathSum();
        List<List<Integer>> paths = sol.pathSum(root, target);

        System.out.println("Paths summing to " + target + ":");
        for (List<Integer> p : paths) {
            System.out.println(p);
        }
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
