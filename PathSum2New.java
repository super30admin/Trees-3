// Time Complexity : O(N)
// Space Complexity : O(h)


import java.util.ArrayList;
import java.util.List;

public class PathSum2New {
  List<List<Integer>> out= new ArrayList();

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

    List<Integer> path = new ArrayList();
    helper(root, targetSum, 0, path);
    return out;

  }

  private void helper(TreeNode root, int target, int currentSum, List<Integer> path){

    if(root == null)return;

    path.add(root.val);

    currentSum = currentSum + root.val;

    if(root.left == null && root.right ==null && target== currentSum ){
      out.add( new ArrayList(path));
    }

    helper(root.left, target, currentSum, path  );
    helper(root.right, target, currentSum, path );

    path.remove(path.size() - 1);
  }
}
