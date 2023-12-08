// Time Complexity : O(N)
// Space Complexity : O(h)

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

  List<List<Integer>> out= new ArrayList();

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

    List<Integer> path = new ArrayList();
    //target= targetSum;
    helper(root, targetSum, 0, path);
    return out;

  }

  private void helper(TreeNode root, int target, int currentSum, List<Integer> path){

    if(root == null)return;

    path.add(root.val);
    currentSum = currentSum + root.val;

    if(root.left == null && root.right ==null && target== currentSum ){
      out.add(path);
    }

    helper(root.left, target, currentSum,  new ArrayList(path) );
    helper(root.right, target, currentSum,  new ArrayList(path) );

  }
}

