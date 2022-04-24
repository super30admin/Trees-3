/**
Problem: https://leetcode.com/problems/path-sum-ii/
TC:O (n) where n is the total number of nodes in the tree.
SC: o(1)
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
    List<List<Integer>> res = null;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        traverse(root, new ArrayList<>(), targetSum, 0);
        return res;
    }
    
    private void traverse(TreeNode root, List<Integer> path, int targetSum, int curSum) {
        if (root == null) return;
        
        // action
        path.add(root.val);
        curSum += root.val;
        
        if (curSum == targetSum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        } else {
            // recurse
            traverse(root.left, path, targetSum, curSum);
            traverse(root.right, path, targetSum, curSum);
        }

        // backtrack
        path.remove(path.size() - 1);
    }
}
/**
Use action, recurse, backtrack template
*/