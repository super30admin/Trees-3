// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;
 
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
    private List<List<Integer>> result; 
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        inorder(root, 0, new ArrayList<>(), targetSum);
        return result;
    }

    public void inorder(TreeNode root, int currSum, List<Integer> path, int targetSum) {
        if (root == null) return;

        List<Integer> newL = new ArrayList<>(path);
        newL.add(root.val);
        currSum += root.val;
        
        if (root.left == null && root.right == null){
            if (currSum == targetSum){
                result.add(newL);
            }
        }
        
        inorder (root.left, currSum, newL, targetSum);
        inorder (root.right, currSum, newL, targetSum);
    }

}