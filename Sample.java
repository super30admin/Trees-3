// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// path sum 2

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
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        
        helper(root, targetSum, 0, new ArrayList());
        return result;
        
    }
    
    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> currList){
        
        
        if(root==null){
            return;
        }
        
        if(root.left==null && root.right==null && currSum + root.val == targetSum){
            
            currSum+=root.val;
            currList.add(root.val);
            result.add(new ArrayList(currList)); 
            currList.remove(currList.size()-1);
            return;
        }
        
        currSum+=root.val;
        currList.add(root.val);
        
//         helper(root.left,targetSum,currSum,new ArrayList(currList));
//         helper(root.right,targetSum,currSum,new ArrayList(currList));
        
        
        helper(root.left,targetSum,currSum,currList);
        helper(root.right,targetSum,currSum,currList);
        
        //nullify line 44
        currList.remove(currList.size()-1);
    }
}


// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//symmetric tree

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
 * 3 2 4 1  4 2 3}
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return false;
        }
        return helper(root.left,root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right){
        
        if(left==null && right==null){
            return true;
        }
        
        if(left==null || right==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        boolean outside = helper(left.left,right.right);
        boolean inside = helper(left.right,right.left);
        return inside && outside;
    }
    
}