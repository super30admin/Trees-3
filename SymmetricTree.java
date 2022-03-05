// Time Complexity : O(n)
// Space Complexity : O(n)

// Approach: create a queue and add the nodes in a level into it.
// Pop twice and check if the values are equal. Do the same for all the levels.

// LC- 101. Symmetric Tree

import java.util.*;

public class SymmetricTree {
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

  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root.left);
    q.add(root.right);

    while (!q.isEmpty()) {
      TreeNode actual = q.poll();
      TreeNode mirror = q.poll();

      if (actual == null && mirror == null) {
        continue;
      }

      if (actual == null || mirror == null || actual.val != mirror.val) {
        return false;
      }

      q.add(actual.left);
      q.add(mirror.right);
      q.add(actual.right);
      q.add(mirror.left);
    }

    return true;
  }
}
