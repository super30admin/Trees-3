// USING BACKTRACKING
// T.C :O(N)
// S.C :O(N)

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
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        target = targetSum;
        if(root == null) return result;
        helper(root, 0, new ArrayList<>());
        
        return result;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> path){
        // base
        if(root == null) return;
        
        //logic
        //action
        
        path.add(root.val);
        sum = sum+root.val;
        
        if(root.left == null && root.right == null){
            if(sum == target){
            result.add(new ArrayList<>(path));
            }
        }
        
        //recursion
        helper(root.left, sum, path);
        helper(root.right, sum, path);
        
        //backtrack
        path.remove(path.size()-1);
        
    }
}