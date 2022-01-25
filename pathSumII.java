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
    int targ;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        targ = targetSum;
        helper(root, 0, new ArrayList<>());
        return result;
    }
    
    public void helper(TreeNode root, int currentSum, List<Integer> path){
        //base
        if(root == null)
            return;
        
        //logic
        currentSum += root.val;
        
        //action
        path.add(root.val);
        
        if(root.left == null && root.right == null){
            if(currentSum == targ)
                result.add(new ArrayList<>(path));
        }
        
        //recursion
        helper(root.left, currentSum, path);  //T.C - O(N^2)  // S.C - O(H) H-Height of tree
        helper(root.right, currentSum, path);
        
        //backtrack
        path.remove(path.size()-1);
    }
}
