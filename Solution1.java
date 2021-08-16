// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


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
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>());
        return result;
    }
    private void dfs(TreeNode root, int targetSum, List<Integer> path){
        //base
        if(root == null){
            return;
        }
        //logic
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(targetSum - root.val == 0){
                result.add(path);
            }
        }
        dfs(root.left, targetSum - root.val, new ArrayList<>(path));
        dfs(root.right, targetSum - root.val, new ArrayList<>(path));
    }
}