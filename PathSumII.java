// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
//## Problem1 (https://leetcode.com/problems/path-sum-ii/)
// Any problem you faced while coding this :


import java.util.ArrayList;
import java.util.List;

// Your code here along with comments explaining your approach
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
public class PathSumII {
    // Time Complexity : O(n*h)
    // Space Complexity :O(n*h)
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;

    }

    private void helper(TreeNode root,int targetSum, int currSum, List<Integer> path){
        //base
        if(root == null) return;

        path.add(root.val);

        currSum += root.val;

        if(root.left == null && root.right == null && targetSum == currSum){
            result.add(path);
        }

        helper(root.left, targetSum, currSum, new ArrayList<>(path)); // we create new list to pass it by reference
        helper(root.right, targetSum, currSum, new ArrayList<>(path));
    }
//**************BackTracking*************************
    List<List<Integer>> result2;
    List<Integer> path; // or we can make it global to pass by reference
    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        result2 = new ArrayList<>();
        path = new ArrayList<>();
        helper(root, targetSum, 0);
        return result2;

    }

    private void helper(TreeNode root,int targetSum, int currSum){
        //base
        if(root == null) return;
        //Action
        path.add(root.val);

        currSum += root.val;

        if(root.left == null && root.right == null && targetSum == currSum){
            result2.add(new ArrayList<>(path)); // we will need to create a new one to by it by refernce
        }
        // recurse
        helper(root.left, targetSum, currSum);
        helper(root.right, targetSum, currSum);
        //backtrack
        path.remove(path.size()-1); // just adding this will give empty list

    }
}
