// Time Complexity :O(n2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no  

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
    int target;
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        target = sum;
        
        helper(root , 0 ,new ArrayList<>());
        return result;
    }
    
     private void helper(TreeNode root, int currSum,List<Integer> temp){
         //base
        if(root == null)return;
        //logic
         currSum += root.val;
         temp.add(root.val);
        if(root.right == null && root.left == null){
            if(currSum == target){
                result.add(new ArrayList<>(temp));
            }
            
        }
        //recursion
         
        helper(root.left, currSum ,temp);
        helper(root.right, currSum ,temp);
         
        //backtracking
         temp.remove(temp.size() - 1);
    }
}