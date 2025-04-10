import java.util.*;

  // Time Complexity: O(n), where n is the number of nodes in the binary tree. Each node is visited once.
  // Space Complexity: O(h), where h is the height of the binary tree. This is due to the recursion stack space.
  // Did this code successfully run on Leetcode : yes
  // Any problem you faced while coding this : no

    /**
     * Finds all root-to-leaf paths in a binary tree that sum to a given target.
     * Uses a recursive helper function to traverse the tree and track the current path and sum.
     * If a valid path is found, it is added to the result list.
     */

public class PathSum2 {
  // Definition for a binary tree node.
  public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
 
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, targetSum, 0, result, new ArrayList<Integer>());
        return result;
    }

    public void helper(TreeNode root, int target, int currentSum, List<List<Integer>> result, List<Integer> currentPath) {

        if(root == null) {
            return;
        }

        currentSum += root.val;
        currentPath.add(root.val);

        if(currentSum == target && root.left == null && root.right == null) {
            result.add(new ArrayList<>(currentPath));
        }

        helper(root.left, target, currentSum, result, currentPath);
        helper(root.right, target, currentSum, result, currentPath);
        currentPath.removeLast();
    }
}
