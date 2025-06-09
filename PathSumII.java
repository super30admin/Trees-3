// Time Complexity :O(n*h)
// Space Complexity : O(n*h)
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
        List<Integer> path = new ArrayList<>();
        helper(root, path, 0, targetSum);
        return result;
        
    }

    private void helper(TreeNode root, List<Integer> path, int currSum, int targetSum){
        //base
        if(root == null) return;
        

        //logic
        //action
        currSum += root.val;
    
        path.add(root.val);
        
        //recurse 
        helper(root.left, path, currSum, targetSum);

        if(root.left == null && root.right == null){
            if(targetSum == currSum){
                System.out.println(path);
                result.add(new ArrayList<>(path));
            }
        }

        helper(root.right, path, currSum, targetSum);

        path.remove(path.size()-1);
    }
}