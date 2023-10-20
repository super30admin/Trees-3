// Time Complexity :O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
        helper(root,0,targetSum, new ArrayList<>());
        return result;
    }
    
   private void helper(TreeNode root,int currentSum,int target, List<Integer> path){
       
   //Base
    if(root == null) 
        return;
       
    currentSum +=   root.val;
    //action
    path.add(root.val);
       
    //pre
    if(currentSum == target && root.left == null && root.right == null)    
       result.add(new ArrayList<>(path));
    //recursion
    helper(root.left, currentSum,target, path);  
    //st.pop()
    helper(root.right, currentSum,target, path);
    //st.pop()
    //backtrack
    path.remove(path.size()-1);  
     
      
       
   }

    
    
    
    
    
}
