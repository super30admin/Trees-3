//METHOD:1
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> result = new ArrayList();
        findPaths(root, sum, new ArrayList<Integer>(), result);
        return result;

    }

    void findPaths(TreeNode root, int sum, List<Integer> current, List<List<Integer>> result) {

        if (root == null)
            return;

        current.add(root.val);

        if (root.left == null && root.right == null && root.val == sum) {
            result.add(current);
            return;
        }

        findPaths(root.left, sum - root.val, new ArrayList<Integer>(current), result);
        findPaths(root.right, sum - root.val, new ArrayList<Integer>(current), result);

    }

}
//METHOD:2 - Recursive Preorder Traversal
// Time Complexity : O(N) since one has to visit each node.
// Space Complexity : O(H)  ; H is tree height.

class Solution {
  int rootToLeaf = 0;

  public void preorder(TreeNode r, int currNumber) {
    if (r != null) {
      currNumber = currNumber * 10 + r.val;
      // if it's a leaf, update root-to-leaf sum
      if (r.left == null && r.right == null) {
        rootToLeaf += currNumber;
      }
      preorder(r.left, currNumber);
      preorder(r.right, currNumber) ;
    }
  }

  public int sumNumbers(TreeNode root) {
    preorder(root, 0);
    return rootToLeaf;
  }
}