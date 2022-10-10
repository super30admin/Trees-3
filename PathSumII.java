// Time Complexity : O(N) n is # of elements
// Space Complexity : O(h) height of the tree for recurssion.
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList<>();
        target = targetSum;
        result = new ArrayList<>();
        dfs(root, 0, new ArrayList<>());

        return result;
    }

    private void dfs(TreeNode root, int sum, List<Integer> path) {
        //base
        if(root == null) return;

        //logic
        //action
        path.add(root.val);
        int currSum = sum + root.val;
        if(root.left == null && root.right == null){
            if(currSum == target) {
                result.add(new ArrayList<>(path));
            }

        }

        //recurrance
        dfs(root.left, currSum, path);
        dfs(root.right, currSum, path);

        //backtrack
        path.remove(path.size() - 1);
    }
}