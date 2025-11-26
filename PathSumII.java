// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes

import java.util.ArrayList;
import java.util.List;

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>(),result);
        return result;
    }
    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path, List<List<Integer>> result){
        // base case
        if(root == null) return;
        //action
        currSum += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(new ArrayList<>(path));
            }
        }
        // recurse
        helper(root.left, targetSum, currSum, path, result);
        helper(root.right, targetSum, currSum, path, result);
        // backtrack
        path.remove(path.size()-1);
    }
}