// Time Complexity : O(n) - Iterating over each element of tree
// Space Complexity : Need help
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Coming up to solution, Had to solution

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();
        
        if(root == null){
            return result;
        }
        
        helper(root, sum, result, subResult);
        return result;
                     
        }
    public void helper(TreeNode node, Integer sum, List<List<Integer>> result, List<Integer> subResult){
        
        if(node == null){
            return;
        }
        
        subResult.add(node.val);
        if(node.val == sum && node.left == null && node.right == null){
            result.add(new ArrayList(subResult));
            subResult.remove(subResult.size()-1);
            return;
        }
        else{
            helper(node.left, sum-node.val, result,subResult);
            helper(node.right, sum-node.val, result,subResult);
        }
        subResult.remove(subResult.size()-1);
    }
}