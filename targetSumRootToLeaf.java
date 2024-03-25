// Time Complexity : O(n*h)
// Space Complexity : O(n*h)
// Did this code successfully run on Leetcode : Yes

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
        helper(root,0,targetSum,new ArrayList<>());
        return result;
    }

    public void helper(TreeNode root, int currSum, int targetSum, List<Integer> path){
        //base
        if(root == null) return;

        //logic
        currSum += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(path);
            }
        }
        helper(root.left,currSum,targetSum,new ArrayList<>(path));
        helper(root.right,currSum,targetSum,new ArrayList<>(path));
    }
}