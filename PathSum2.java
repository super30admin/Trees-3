import java.util.ArrayList;
import java.util.List;

// Recursive solution
// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach:
//1) Traverse in an inroder way and maintain current sum and the list of nodes at each of the node
//2) whent it reaches leaf nodes, check if the current sum is equal to targetsum

//Backtrack Solution
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach:
//

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
public class PathSum2 {
	List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        target = sum;
        helper(root, 0, new ArrayList<>());
        return result;
    }
    //recursive
    // public void helper(TreeNode root, int currSum, List<Integer> path){
    //     if(root == null)return;
    //     currSum += root.val;
    //     path.add(root.val);
    //     if(root.left == null && root.right == null){
    //         if(currSum == target){
    //             result.add(path);
    //         }
    //     }
    //     helper(root.left, currSum, new ArrayList<>(path));
    //     helper(root.right, currSum, new ArrayList<>(path));
    // }
    //backtrack
    public void helper(TreeNode root, int currSum, List<Integer> path){
        //base condition
        if(root == null)return;
        currSum += root.val;
        //action
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == target){
                result.add(new ArrayList<>(path));
            }
        }
        helper(root.left, currSum, path);
        helper(root.right, currSum, path);
        //backtrack
        path.remove(path.size()-1);
    }
}
