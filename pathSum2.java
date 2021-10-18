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
    List<List<Integer>> result= new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root,targetSum,0,new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int targetSum, int currSum, List<Integer>path)
    {
        if (root==null)
            return;
        /*path.add(root.val);
        currSum= currSum + root.val;*/
        //action
        
        if(root.left == null && root.right == null)
        {
            
            currSum= currSum + root.val;
            System.out.println("currSum:"+ currSum);
            
            if(currSum == targetSum)
            { 
                path.add(root.val);
                result.add(new ArrayList<>(path));
                path.remove(path.size()-1);
            }
        }
        path.add(root.val);
        currSum= currSum + root.val;
        //recursion
        helper(root.left,targetSum,currSum,path);
        helper(root.right,targetSum,currSum,path);
        //backtracking
        path.remove(path.size()-1);
    }
}