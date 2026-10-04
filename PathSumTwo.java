//Time Complexity : O(n)
//Space Complexity : O(h)
import java.util.ArrayList;
import java.util.List;
class TreeNode {
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

public class PathSumTwo {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, 0,new ArrayList<>(), targetSum);
        return result;
    }

    private void helper(TreeNode root, int curr, List<Integer> path, int target) {
        if(root == null) return;

        curr += root.val;
        path.add(root.val);

        if(root.left == null & root.right == null) {
            if(curr == target) {
                result.add(new ArrayList<>(path));
            }
        }

        helper(root.left, curr, path , target);
        helper(root.right, curr, path, target);
        path.remove(path.size() - 1);


    }
}
