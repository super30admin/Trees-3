// Time Complexity : O(n)
// Space Complexity : O(n) - for the recursion stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : local and global variables were not being updated correctly, which was giving wrong results. After fixing that, it worked fine.

// Your code here along with comments explaining your approach: base case is when the root is null, return. Add the current node value to the current sum and add it to the path. If the current node is a leaf node, check if the current sum equals the target sum. If it does, add the current path to the result list. Recurse on the left and right subtrees. After returning from recursion, backtrack by removing the last node from the path.
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
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path){
        // base case
        if(root == null) return;

        //action
        currSum += root.val;
        path.add(root.val);
      
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(new ArrayList<>(path));
            }
        }

        // recurse
        helper(root.left, targetSum, currSum, path);
        helper(root.right, targetSum, currSum, path);

        // backtrack
        path.remove(path.size()-1);
    }
}
