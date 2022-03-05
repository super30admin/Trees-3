// Time Complexity : O(n^2)
// Space Complexity : O(n)

// Approach: Iterate through the tree. At every node, we check if it's leaf and if
// the sum is equal to the value of the current node. If it's true, add it to the result list. 
// If it's not, we iterate to the left and right subtrees and also decrement the sum needed
// by the current node's value.

// LC- 113. Path Sum II

import java.util.*;

public class PathSum2 {
  public class TreeNode {
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

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    pathSum(root, targetSum, new ArrayList(), result);
    return result;
  }

  public void pathSum(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
    if (root == null) {
      return;
    }

    path.add(root.val);

    if (root.left == null && root.right == null && sum == root.val) {
      result.add(path);
    }

    pathSum(root.left, sum - root.val, new ArrayList(path), result);
    pathSum(root.right, sum - root.val, new ArrayList(path), result);
  }
}
