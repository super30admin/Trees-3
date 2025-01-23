
/**
 * Time Complexity: O(N)
 * Space Complexity: O(H): recursive stack
 * Did this code successfully run on Leetcode : Yes
 */

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }

    boolean isSymmetric = true;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root.left);
    queue.add(root.right);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode left = queue.poll();
        TreeNode right = queue.poll();
        if (left == null && right == null) {
          continue;
        }
        if (left == null || right == null) {
          return false;
        }
        if (left.val != right.val) {
          isSymmetric = false;
          break;
        }
        queue.add(left.left);
        queue.add(right.right);
        queue.add(left.right);
        queue.add(right.left);
      }
    }
    return isSymmetric;
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
