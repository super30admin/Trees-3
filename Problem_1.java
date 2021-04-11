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
// Time Complexity : O(n) 
// Space Complexity :O(n)
class Solution {
    List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return res;
        helper(root,targetSum, 0, new ArrayList<>());
        return res;
    }
    void helper(TreeNode root, int targetSum, int sum, ArrayList<Integer> path){
        if(root==null) return;
        sum+=root.val;
        path.add(root.val);
        
        helper(root.left, targetSum, sum,(path));
        if(root.right==null && root.left==null && targetSum==sum){
            res.add(new ArrayList<>(path));
        }
        helper(root.right, targetSum, sum,(path));
        //backtracking
        path.remove(path.size()-1);
    }
}