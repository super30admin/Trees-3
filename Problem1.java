// Time Complexity : O(# of nodes)
// Space Complexity : O(h) where h is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.*;

class Solution {

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
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;        
    }
    
    private void dfs(TreeNode node, int sum, List<Integer> path, List<List<Integer>> paths) {
        
        if (node == null) {
            return;
        }
        
        path.add(node.val);
        
        if (node.left == null && node.right == null && node.val == sum) {
            paths.add(new ArrayList<>(path));
        }
        
        else {
            dfs(node.left, sum - node.val, path, paths);    
            dfs(node.right, sum - node.val, path, paths);
        }
        
        path.remove(path.size()-1);
    }
}