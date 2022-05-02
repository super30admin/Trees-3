// Time Complexity : O(n)
// Space Complexity : O(n*n)
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
    List<List<Integer>> output = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> li = new ArrayList<Integer>();
        if(root!=null){
            helper(root,root.val,targetSum,li);
        }
        return output;
    }
    public void helper(TreeNode root,int sum,int targetSum,List<Integer> li){
        List<Integer> newList = new ArrayList<Integer>();
        newList.addAll(li);
        newList.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==targetSum){
                output.add(newList);
            }
            return;
        }
        if(root.left!=null){
          helper(root.left,sum+root.left.val,targetSum,newList);  
        }
        if(root.right!=null){
          helper(root.right,sum+root.right.val,targetSum,newList); 
        }
        
    }
}