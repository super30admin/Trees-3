// Time Complexity : o(n*h)
// Space Complexity :  o(n*h) + o(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


import java.util.ArrayList;
import java.util.List;

// Your code here along with comments explaining your approach
/*
 * Approach:
 * 1. We are given a binary tree and a target sum. Our goal is to find all root-to-leaf paths where each path's sum equals the target sum.
 * 2. We use a recursive depth-first search (DFS) approach to explore all possible paths from the root to the leaves.
 * 3. At each node, we add the node's value to the current path sum (`curr`) and to the current path list (`path`).
 * 4. If we reach a leaf node and the current path sum equals the target sum, we add the path to our result list.
 * 5. We make recursive calls to the left and right children to continue the search.
 * 6. We create a new list (`path`) at each recursive call to avoid modifying the same list in different branches of the recursion.
 */
//Problem1 (https://leetcode.com/problems/path-sum-ii/)
public class problem1 {
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
 List<List<Integer>> result ;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

      this.result = new ArrayList<>();

     helper(root, targetSum, 0, new ArrayList<>());
     return result;

    }
    public void helper(TreeNode root, int targetSum, int curr, List<Integer> res) {

    //base case
    if (root == null) return;


    //logic
     List<Integer> path = new ArrayList<>(res);
     curr += root.val;
     path.add(root.val);
     if (root.left == null && root.right == null) {
        if (curr == targetSum) {
            result.add(path);
        }
     }
     helper(root.left, targetSum, curr + root.val, path);
     helper(root.right, targetSum, curr + root.val, path);

    }
}