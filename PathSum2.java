//Time complextity - O(n)
//Space complexity - O(n) //height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
      result = new ArrayList<>();
      target = targetSum;
      if(root == null) {
        return result;
      }
      helper(root, 0, new ArrayList<>());
      return result;
   }
  private void helper(TreeNode root, int currSum, List<Integer> path) {
       //base
       if(root == null) return;
    
      //logic
       //action
       currSum += root.val;
       path.add(root.val);
    
       helper(root.left, currSum, path);
      
       helper(root.right, currSum, path);
       if(root.left == null && root.right == null) {
         if(target == currSum) {
           result.add(new ArrayList<>(path));
         }
       }
       //reversing action(backtracking)
       path.remove(path.size()-1);
    }
}