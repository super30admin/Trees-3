// Problem: https://leetcode.com/problems/path-sum-ii/
// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach : I have used DFS approach to solve this problem. 
//I have kept a track of current path and checked if the current  node is a leaf node with a value equal to the targetting sum. 
//If yes, then I have added the path to the result list. If not, then I have recursively called the left and right child of the current node with the updated target sum. 
//I have removed the last element from the path list after the recursive call to backtrack and explore other paths.

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
    int sum;
     List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
      this.result= new ArrayList<>();
      helper(root,0,targetSum,new ArrayList<>());
      return result;
    }

    public void helper(TreeNode root,int currSum,int targetSum, List<Integer> path){
           //base
           if(root==null) return;

           currSum+=root.val;

           path.add(root.val);

          if(root.left==null && root.right==null){
            if(currSum==targetSum){
                result.add(new ArrayList<>(path));
            }
          }

          helper(root.left,currSum,targetSum,path);
           helper(root.right,currSum,targetSum,path);
           //backtracking
           path.remove(path.size()-1);
    }
}
