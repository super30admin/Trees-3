// Time Complexity : O(n) where n is number of nodes in the input tree
// Space Complexity : O(h) where h is height of the binary tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
public class Pathsum2{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return new ArrayList<>();
        }
        
        List<List<Integer>> res = new ArrayList<>();
        helper(root, targetSum, 0, res, new ArrayList<>());
        return res;
    }
    
    private void helper(TreeNode root, int targetSum, int currSum, List<List<Integer>> res, List<Integer> path){
        
        //base
        if(root == null){
            return;
        }
        
        //logic
        path.add(root.val);
        
        //if it is leaf node, check if adding value of leaf node makes the target sum, if it does than add to the result path
        if(root.left == null && root.right == null){
            if(currSum + root.val == targetSum){
                res.add(new ArrayList<>(path));
            }
        }
        helper(root.left, targetSum, currSum + root.val, res, path);
        helper(root.right, targetSum, currSum + root.val, res, path);
        
        //since list is a non premitive data structure, 
        //it stores address of the list data, so need to remove value from the list to backtrack and process other subtree
        path.remove(path.size()-1);
    }

    //Definition for a binary tree node.
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