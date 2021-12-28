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
        
        result = new ArrayList<List<Integer>>();
        helper(root, targetSum,0,new ArrayList<>());
        return result;
        
    }
    
    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path)
    {
        
        if(root==null)
        {
            return;
        }
        path.add(root.val);
        if(root.left==null && root.right==null)
        {
           if(currSum + root.val == targetSum )
           {
               result.add(new ArrayList<>(path));
           }
           return;
        }
        
        helper(root.left, targetSum, currSum+root.val , path);
        helper(root.right, targetSum, currSum+root.val , path);
                          path.remove(path.size()-1);
    }
}