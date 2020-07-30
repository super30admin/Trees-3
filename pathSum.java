// Time Complexity :O(n^2) where n is the no. of nodes in the tree
// Space Complexity :O(h) where h is the height of the tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


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
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        if(root == null) return result;
        target = sum;
        helper(root,0,new ArrayList<>());
        return result;
    }
    
    private void helper(TreeNode root, int currSum, List<Integer> temp){
        //base case
        if(root == null) return;
        currSum += root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null){
            if(target == currSum){
                result.add(new ArrayList<>(temp));
            }
        }
        
        //logic
        
        helper(root.left,currSum,temp);
        helper(root.right,currSum,temp);
        
        //backtracking
        temp.remove(temp.size() -1);
        
    }
    
}