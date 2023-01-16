// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// Backtrack approach

public class PathSumII {
    private List<List<Integer>> resultPaths;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        resultPaths = new ArrayList<>();
        helper(root, 0, new ArrayList<>(), targetSum);
        return resultPaths;
    }

    private void helper(TreeNode root, int currentSum, List<Integer> currentPath, int targetSum) {
        if (root == null) {
            return;
        }

        currentSum += root.val;
        currentPath.add(root.val);

        if (root.left == null && root.right == null) {
            if (currentSum == targetSum) {
                resultPaths.add(new ArrayList<>(currentPath));
            }
        }

        helper(root.left, currentSum, currentPath, targetSum);
        helper(root.right, currentSum, currentPath, targetSum);

        currentPath.remove(currentPath.size() - 1);
    }
}


// Time Complexity : O(N^2) ,Worst case
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class PathSum2 {
    private List<List<Integer>> resultPaths;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        resultPaths = new ArrayList<>();
        helper(root, 0, new ArrayList<>(), targetSum);
        return resultPaths;
    }

    private void helper(TreeNode root, int currentSum, List<Integer> currentPath, int targetSum) {
        if (root == null) {
            return;
        }

        currentSum += root.val;
        List<Integer> list = new ArrayList<>(currentPath);
        list.add(root.val);

        if (root.left == null && root.right == null) {
            if (currentSum == targetSum) {
                resultPaths.add(list);
            }
        }

        helper(root.left, currentSum, list, targetSum);
        helper(root.right, currentSum, list, targetSum);
    }
}


