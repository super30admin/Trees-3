// Problem1 (https://leetcode.com/problems/path-sum-ii/)

// Time Complexity : O(n*h)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, a global result is taken for adding all the paths that gives us the desired target sum. For every node, we add the value of node to path
 * and whenever the path current sum is equals to target sum,create deep copy of it and add it to result. Remove the last element after every
 * recursive stack. The result gives us all the paths that gives target sum. 
 */

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, new ArrayList<>(), 0, targetSum);
        return result;
    }

    private void helper(TreeNode root, List<Integer> path, int currSum, int targetSum){
        if(root == null) return;
        currSum += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(new ArrayList<>(path));
            }
        }

        //recurssion
        helper(root.left, path, currSum, targetSum);
        helper(root.right, path, currSum, targetSum);
        //backtracking
        path.remove(path.size()-1); // remove last element backtracking
    }
}


