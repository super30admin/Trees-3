import java.util.ArrayList;
import java.util.List;

public class pathsum {
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

    List<List<Integer>> nodeList = new ArrayList<>();


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> list = new ArrayList<>();

        helper(root, list, targetSum, 0);
        return nodeList;
    }

    private void helper(TreeNode root, List<Integer> list, int target, int curSum){
        //base
        if(root == null) return;

        //logic
        curSum += root.val;
        //if(curSum > target) return;

        list.add(root.val);

        if(root.right == null && root.left == null && curSum == target){
            nodeList.add(new ArrayList<>(list));
        }

        helper(root.left, list, target, curSum);

        helper(root.right, list, target, curSum);

        list.remove(list.size() - 1);

    }

}
