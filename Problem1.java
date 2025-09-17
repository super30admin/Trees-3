// 113. Path Sum II
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
 /*
TC: O(n)
SC: O(h)
Ran on leetcode: Yes
Traverse to all the leaf nodes keeping track of the path and path sum and if the path sum is equal to the target then add that path to result.
 */
class Solution {
    
    private List<List<Integer>> paths;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.paths = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>(), 0);
        return paths;
    }

    private void helper(TreeNode root, int targetSum, List<Integer> path, int pathSum){
        // base case
        if(root == null) return;

        // calculate current path sum
        pathSum += root.val;
        // keep the current path
        path.add(root.val);
        
        // leaf node
        if(root.left == null && root.right == null){
            // if path sum is equal to target sum add the path to paths
            if(pathSum == targetSum){
                paths.add(new ArrayList<>(path));
            }
        }
        
        // traverse left subtree
        helper(root.left, targetSum, path, pathSum);
        //traverse right subtree
        helper(root.right, targetSum, path, pathSum);

        // backtrack once we have traversed left and right subtree
        path.remove(path.size() - 1);
    }
}