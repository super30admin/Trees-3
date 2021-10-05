// Time Complexity : o(n^2)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes


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
        if(root == null ){
            return new ArrayList<>();
        }
        
        result = new ArrayList<>();
        dfs(root, targetSum , new ArrayList<>());
        return result;
        
        
        
    }
    
    private void dfs(TreeNode root, int targetSum , List<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(targetSum - root.val == 0){
                result.add(path);
                
            }
        }
        
        dfs(root.left, targetSum - root.val, new ArrayList<> (path));
        dfs(root.right, targetSum - root.val, new ArrayList<> (path));
        
    }
}