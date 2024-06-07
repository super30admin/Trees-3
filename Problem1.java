/*
    LC - 113. Path Sum II
    TC - o(n)
     copying elements at the leaf node - but leaf nodes is less comparatively. and out of which target matching is less. therefore it optimized the time.

    SC - O(h)  
*/

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
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        path = new ArrayList<>();
        dfs(root, 0, targetSum);
        return result;
    }
    public void dfs(TreeNode root, int currSum, int target) {
        if(root == null) {
            return ;
        }
        currSum = currSum + root.val;
        // action
        path.add(root.val);
        if(root.left == null && root.right == null) {
            if(currSum == target) {
                result.add(new ArrayList<>(path));
            }
            //return ;
        }
        // recurse
        dfs(root.left, currSum, target);
        dfs(root.right, currSum, target);
        // backtrack
        path.remove(path.size() - 1);
    }
}