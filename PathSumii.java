// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
import java.util.ArrayList;
import  java.util.List;
//   Definition for a binary tree node.
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
 
class PathSumii {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, new ArrayList<>(), targetSum, 0);
        return result;
    }

    private void helper(TreeNode root, List<Integer> list, int targetSum, int currSum)
    {
        if(null == root)
        {
            return;
        }
        currSum += root.val;
        list.add(root.val);
        if(null == root.left && null == root.right)
        {
            if(currSum == targetSum)
            {
                result.add(new ArrayList<>(list));
            }
        }

        helper(root.left, list, targetSum, currSum);
        helper(root.right, list, targetSum, currSum);

        list.remove(list.size() - 1);
    }
}