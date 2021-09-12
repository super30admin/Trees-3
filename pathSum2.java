// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

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
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        target = targetSum;
        //null
        if(root == null) return result;
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int currSum){
        //base
        if(root == null) return;
        // action
        path.add(root.val);
        currSum = currSum + root.val;
        if(root.left == null && root.right == null){
            if(currSum == target){
                result.add(new ArrayList<>(path));
            }
        }
        //recusion
        helper(root.left, currSum);
        helper(root.right, currSum);
        // backtracking
        path.remove(path.size() - 1);

    }
}