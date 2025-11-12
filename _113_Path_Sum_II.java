/**** Method 1 ****/
//Time Complexity: O(n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

//We traverse the tree and add the value of node to list, later check if is leaf or not,if leaf check the target sum is equal to node.val, if yes add to ans list if not move left with sum reduced and move right with sum reduced. return ans at the end.

import java.util.ArrayList;
import java.util.List;

public class _113_Path_Sum_II {

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> main = new ArrayList<>();
    pathSum1(root, sum, main, new ArrayList<>());
    return main;
  }

  private void pathSum1(
    TreeNode node,
    int sum,
    List<List<Integer>> main,
    List<Integer> list
  ) {
    if (node == null) {
      return;
    }
    list.add(node.val);
    if (node.left == null && node.right == null) {
      if (sum == node.val) {
        main.add(new ArrayList<>(list));
      }
    }
    pathSum1(node.left, sum - node.val, main, list);
    pathSum1(node.right, sum - node.val, main, list);

    list.remove(list.size() - 1);
  }
}
