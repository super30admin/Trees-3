// https://leetcode.com/problems/path-sum-ii/

// Time Complexity : O(N)
// Space Complexity : O(Height of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
    // result
     List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        if(root==null){
            return result;
        }

        List<Integer> currPath = new ArrayList<>();
        dfs(root, currPath, 0, targetSum);

        return result;
    }

    private void dfs(TreeNode root, List<Integer> currPath, int currSum, int targetSum){
        // base
        if(root==null){
            return;
        }

        //action
        currPath.add(root.val);
        currSum += root.val;
        if(root.left==null && root.right==null && currSum==targetSum){
            //leaf node and curr sum equal to target sum
            result.add(new ArrayList<Integer>(currPath));
        }


        //recursion
        dfs(root.left, currPath, currSum, targetSum);
        dfs(root.right, currPath, currSum, targetSum);

        // backtrack
        currPath.remove(currPath.size() - 1);
    }
}