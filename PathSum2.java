// Time Complexity : O(n)
// Space Complexity : O(h) recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    dfs(path, result, 0, root, targetSum);
    return result;
  }

  private void dfs(List<Integer> path, List<List<Integer>> result, int currentSum, TreeNode root, int targetSum) {
    if (root == null) {
      return;
    }
    currentSum += root.val;
    path.add(root.val);
    dfs(path, result, currentSum, root.left, targetSum);
    if (root.left == null && root.right == null) {
      if (currentSum == targetSum) {
        result.add(new ArrayList<>(path));
      }
    }
    dfs(path, result, currentSum, root.right, targetSum);
    path.remove(path.size() - 1);
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

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
}
