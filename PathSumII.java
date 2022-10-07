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
// Time Complexity :O(n*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return new ArrayList<>();
        target = targetSum;
        result = new ArrayList<>();
        dfs(root, 0, new ArrayList<>());
        return result;
    }
    private void dfs(TreeNode root, int sum, List<Integer> path){
        //base
        if(root == null)
            return;
        //logic
        //action
        path.add(root.val);
        int currsum = sum + root.val;
        if(root.left == null && root.right == null){
            if(target == currsum)
                result.add(new ArrayList<>(path));
        }
        
        //recurse
        dfs(root.left, currsum, path);
        dfs(root.right, currsum, path);
        
        //backtrack
        path.remove(path.size() - 1);
        
    }
}
