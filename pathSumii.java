import java.util.ArrayList;
import java.util.List;

public class pathSumii {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        target = sum;
        if(root == null) return result;
        dfs(root, 0, new ArrayList<>());
        return result;

    }
    private void dfs(TreeNode root, int currSum, List<Integer> temp){
        if(root == null) return;
        currSum += root.val;
       temp.add(root.val);
        if(root.left == null && root.right == null){
            if(target == currSum){
          result.add(new ArrayList<>(temp));
            }
        }
       // logic
        dfs(root.left, currSum, temp);
        dfs(root.right, currSum, temp);

        // backtrack
        temp.remove(temp.size() - 1);
    }
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
}
