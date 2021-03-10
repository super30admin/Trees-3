// Time Complexity :
O(n) where n = no.of nodes in tree Since we are visiting each TreeNode of the tree
// Space Complexity :
recursive stack would be taking space of O(height of the tree tree) 
// Did this code successfully run on Leetcode :
Yes
// Any problem you faced while coding this :
Adding every possible result to the Resultant list.

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //define a shell function
        
        List<List<Integer>> result=new ArrayList<>();
       
        helper(root,targetSum,new ArrayList<Integer>(),result);
        
        return result;
        
        
    }
    
    private void helper(TreeNode root, int targetSum,List<Integer> tempList, List<List<Integer>> result){
      //base case
        if(root == null) return ;
        
        //check if we have a valid path
        tempList.add(root.val);
        if(root.left == null && root.right == null && root.val==targetSum){
            result.add(tempList);
            return;
        }  
        //propogate or continue to recurse
        helper(root.left, targetSum-root.val, new ArrayList<Integer>(tempList), result)  ;
         
        helper(root.right,targetSum-root.val, new ArrayList<Integer>(tempList), result)  ;
       
      
    }
}